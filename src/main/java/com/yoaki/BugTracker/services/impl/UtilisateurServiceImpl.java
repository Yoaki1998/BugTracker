package com.yoaki.BugTracker.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hibernate.mapping.Any;
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
import com.auth0.json.mgmt.users.User;
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

  
    private final String domain ="dev-yoakiniscoise.eu.auth0.com" ;

    private final String clientId = "hVwYQaRckdYv3WFJFq0bl7TDMAmV24L2";

    private final String clientSecret = "Xk6mk_3mYDNvxDzPUjaYodtjflVTersmBsDsDDD004YXOoFdB5RGz_wSpU8TCzJ7" ;

    private List<User> authUsers = new ArrayList<>();

    @Override
    public List<UtilisateurDTO> getAllUtilisateurs() {
        setAuthUserInDb();
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

        Utilisateur updatedUtilisateur = utilisateurRepository.save(existingUtilisateur);
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

    private void pullAuthUser() {
        String token = getManagementApiToken();
        
        JsonParser jsonParser = JsonParserFactory.getJsonParser();
        Map<String, Object> jsonMap = jsonParser.parseMap(token);
        String accessToken = (String) jsonMap.get("access_token");
        System.out.println("Token: " + accessToken);

        try {
        ManagementAPI mgmt = ManagementAPI.newBuilder(domain, accessToken).build();
        Response<UsersPage> response = mgmt.users().list( new UserFilter() ).execute();
        System.out.println("La boucle doit tourner :"+ response.getBody().getItems().size());
        for ( int i=0; i<= response.getBody().getItems().size()-1; ++i ) {;
            authUsers.add(response.getBody().getItems().get(i));
            System.out.println(authUsers);
        }
        } catch (Auth0Exception e) {
            e.printStackTrace();
        }

    }

    private void setAuthUserInDb() {
        pullAuthUser();
        for (int i=0; i<= authUsers.size()-1; ++i) {
            User data = authUsers.get(i);
            if ( utilisateurRepository.findById(data.getId()) == null ) {
                Utilisateur newUser = new Utilisateur();
                newUser.setId(data.getId());
                newUser.setEmail(data.getEmail());
                newUser.setEmail_verified(data.isEmailVerified());
                newUser.setName(data.getName());
                newUser.setPicture(data.getPicture());
                utilisateurRepository.save(newUser);
            } else {
                Utilisateur existingUser = utilisateurRepository.findById(data.getId()).orElse(null);
                existingUser.setId(data.getId());
                existingUser.setEmail(data.getEmail());
                existingUser.setEmail_verified(data.isEmailVerified());
                existingUser.setName(data.getName());
                existingUser.setPicture(data.getPicture());
                utilisateurRepository.save(existingUser);
            }
        }
    }

}

