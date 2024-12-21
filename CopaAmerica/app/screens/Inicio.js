import { StyleSheet, View, FlatList, TouchableHighlight } from 'react-native';
import { getUsuario } from '../servicios/ServicioUsuarios';
import { Button, Text } from '@rneui/base'


export const Inicio = ({navigation}) => {

  /* let usuario = getUsuario(); */

  let usuario={
    usu_cedula: "0923138747",
    usu_nombres: "Adrian",
    usu_apellidos: "Bacilio",
  };  
    return (
        <View style={styles.container}>
          <Text style={styles.bienvenida}>Bienvenido</Text>
          <Text style={styles.usuarioS}>{usuario.usu_nombres} {usuario.usu_apellidos} </Text>
          <Button
            title='Lista de partidos'
            buttonStyle={styles.btnPartidos}
            onPress={() => {
                navigation.navigate("ListaPartidosNav", {usuario:usuario});
            }}
          />
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
      flex: 1,
      backgroundColor: '#fff',
      alignItems: 'center',
      justifyContent: 'center',
    },
    bienvenida: {
      fontWeight: "bold",
      fontSize: 45,
    },
    usuarioS:{
      fontSize: 18,
    },
    btnPartidos:{
      borderRadius: 10,
      marginTop: 10,
      paddingHorizontal: 20,
      backgroundColor:"#11a85b"
    }
  });
  