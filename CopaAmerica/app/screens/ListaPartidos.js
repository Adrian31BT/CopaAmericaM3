import { StyleSheet, Text, View, FlatList, TouchableHighlight } from 'react-native';
import { getPartidos } from '../servicios/ServicioPartidos';
import { ListItem } from '@rneui/themed'
import { useState } from 'react';

export const ListaPartidos = ({navigation, route}) => {

  let usuario;
  usuario = route.params.usuario;

  const [time, setTime] = useState();
  const refreshList = () =>{
    setTime(new Date().getTime());
  }

  const ItemPartido = ({ partido }) => {
    return <TouchableHighlight
    onPress={()=>{
      navigation.navigate("FormPronosticosNav", {partido:partido, usuario:usuario, fnRefresh:refreshList});
    }}
    >
    <ListItem bottomDivider>
      <ListItem.Content>
        <ListItem.Title>{partido.par_codigo}</ListItem.Title>
      </ListItem.Content>
      <ListItem.Content>
        <ListItem.Subtitle>{partido.equipo1.equ_nombre}</ListItem.Subtitle>
      </ListItem.Content>
      <ListItem.Content>
        <ListItem.Subtitle>{partido.equipo2.equ_nombre}</ListItem.Subtitle>
      </ListItem.Content>
      <ListItem.Chevron/>
    </ListItem>
    </TouchableHighlight>
  }

  return <View style={styles.container}>
    
    <FlatList
      data={getPartidos()}
      renderItem={({ item }) => {
        return <ItemPartido partido={item} />
      }}
      keyExtractor={(item) => {
        return item.par_codigo
      }}
      extraData={time}
    />
  </View>
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'strech',
    justifyContent: 'center',
  },
});
