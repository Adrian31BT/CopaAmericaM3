let usuario; 
export const getUsuario= () => {
    fetch("http://192.168.3.201:8080/ca_pronostico-1.0.0/rest/usuarios/buscarPorCedula/0923138747")
    .then((response) => {
      return response.json();
    })
    .then((json) => {
      usuario = json;
      console.log(usuario);  
    });  
    return usuario;
    /* setTimeout(() => {  
      console.log(usuario); // Usar la variable aquí con cuidado  
    }, 2000);   
    return usuario; */
};

