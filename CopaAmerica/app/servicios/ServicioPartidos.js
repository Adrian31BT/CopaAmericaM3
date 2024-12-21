let partidos = [];

export const getPartidos= () => {
  partidos = [];
    fetch("http://192.168.3.201:8080/ca_pronostico-1.0.0/rest/partidos/obtenerPartidos")
    .then((response) => {
      return response.json();
    })
    .then((json) => {
      json.forEach((item)=>{
        partidos.push(item);
        console.log(partidos);
      })
    });
    return partidos;
};




