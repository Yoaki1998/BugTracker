export const environment = {
    production: false,
    apiUrl: '/api',
    auth:{
      domain: 'dev-yoakiniscoise.eu.auth0.com',
      clientId: 'z5eBSk8b7S5KvJzM3L9ZpxhxDQIuV9PK',
      authorizationParams: {
        redirect_uri: window.location.origin,
        audience:"http://localhost:8080/api"
      },
    }
  };