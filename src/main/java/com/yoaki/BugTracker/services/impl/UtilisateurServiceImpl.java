package com.yoaki.BugTracker.services.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.auth0.client.mgmt.ManagementAPI;
import com.auth0.client.mgmt.filter.UserFilter;
import com.auth0.exception.Auth0Exception;
import com.auth0.json.mgmt.users.UsersPage;
import com.auth0.net.Response;
import com.yoaki.BugTracker.domain.Utilisateur;
import com.yoaki.BugTracker.domain.dto.UtilisateurDTO;
import com.yoaki.BugTracker.mappers.Mapper;
import com.yoaki.BugTracker.repositories.UtilisateurRepository;
import com.yoaki.BugTracker.services.UtilisateurService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final Mapper<Utilisateur, UtilisateurDTO> utilisateurMapper;
    private final RestTemplate restTemplate;

    @Value("${app.api.domain}")
    private final String domain ;
    @Value("${app.api.clientId}")
    private final String clientId;
    @Value("${app.api.clientSecret}")
    private final String clientSecret ;

    @Override
    public List<UtilisateurDTO> getAllUtilisateurs() {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        return utilisateurs.stream()
                .map(utilisateurMapper::mapTo)
                .collect(Collectors.toList());
    }

    @Override
    public UtilisateurDTO getUtilisateurById(String id) {
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElse(null);
        return utilisateurMapper.mapTo(utilisateur);
    }

    @Override
    public UtilisateurDTO saveUtilisateur(UtilisateurDTO utilisateurDTO) {
        Utilisateur utilisateur = utilisateurMapper.mapFrom(utilisateurDTO);
        Utilisateur savedUtilisateur = utilisateurRepository.save(utilisateur);
        return utilisateurMapper.mapTo(savedUtilisateur);

    }

    @Override
    public void deleteUtilisateur(String id) {
        utilisateurRepository.deleteById(id);
        // Ajouter la fonction qui delete un user d'Auth0
    }

    @Override
    public UtilisateurDTO updateUtilisateur(String id, UtilisateurDTO utilisateurDTO) {
        Utilisateur existingUtilisateur = utilisateurRepository
                .findById(id).orElse(null);
        Utilisateur newUtilisateur = utilisateurMapper.mapFrom(utilisateurDTO);

        existingUtilisateur.setName(newUtilisateur.getName());
        existingUtilisateur.setEmail(newUtilisateur.getEmail());
        existingUtilisateur.setPicture(newUtilisateur.getPicture());
        existingUtilisateur.setSubmitted(newUtilisateur.getSubmitted());
        existingUtilisateur.setAssigned(newUtilisateur.getAssigned());

        Utilisateur updatedUtilisateur = utilisateurRepository
                .save(existingUtilisateur);
        return utilisateurMapper.mapTo(updatedUtilisateur);
    }

    private String getManagementApiToken() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        String body = "grant_type=client_credentials&client_id=" + clientId + "&client_secret=" + clientSecret +
                "&audience=https%3A%2F%2F" + domain + "%2Fapi%2Fv2%2F";

        ResponseEntity<String> response = restTemplate.exchange(
                "https://" + domain + "/oauth/token",
                HttpMethod.POST,
                new HttpEntity<>(body, headers),
                String.class);

        return response.getBody();

    }

    @Override
    public void updateDatabaseWithAuth0() {
        String token = getManagementApiToken();
        
        JsonParser jsonParser = JsonParserFactory.getJsonParser();
        Map<String, Object> jsonMap = jsonParser.parseMap(token);
        String accessToken = (String) jsonMap.get("access_token");
        System.out.println("Token: " + accessToken);

        try {
        ManagementAPI mgmt = ManagementAPI.newBuilder(domain, accessToken).build();
        Response<UsersPage> response = mgmt.users().list( new UserFilter() ).execute();
            System.out.println("Users: " + response.getBody().getItems().get(1).getEmail() );
        } catch (Auth0Exception e) {
            e.printStackTrace();
        }

    }

}

