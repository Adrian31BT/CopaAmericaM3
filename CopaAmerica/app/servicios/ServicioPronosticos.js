export const insertPronosticos = (post, fnExito) => {
    const config={
        method: 'POST',
        body:JSON.stringify({
            usuario:post.usuario,
            partido: post.partido,
            pro_marcador1: post.pro_marcador1,
            pro_marcador2: post.pro_marcador2
        }),
        headers:{
            'Content-type': 'application/json',
        }
    }
    fetch("http://192.168.3.201:8080/ca_pronostico-1.0.0/rest/pronosticos/insertar", config)
    .then((response) => {
      return response.json();
    })
    .then((json) => {
      console.log(json);
    });
    fnExito();
  };