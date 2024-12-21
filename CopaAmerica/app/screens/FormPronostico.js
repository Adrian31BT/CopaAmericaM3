import { StyleSheet, View, Alert } from 'react-native';
import { Input, Button } from '@rneui/base'
import { useState } from 'react';
import { insertPronosticos } from '../servicios/ServicioPronosticos'

export const FormPronostico = ({navigation, route}) => {

    const [pro_marcador1, setPro_marcador1] = useState("");
    const [pro_marcador2, setPro_marcador2] = useState(""); 
    const [errorMarcador, setErrorMarcador] = useState();

    let nombre_equipo1;
    let nombre_equipo2;
    let iso_equipo1;
    let iso_equipo2;
    let partido;
    let usuario;
    
    nombre_equipo1 = route.params.partido.equipo1.equ_nombre;
    nombre_equipo2 = route.params.partido.equipo2.equ_nombre;
    iso_equipo1 = route.params.partido.equipo1.equ_iso;
    iso_equipo2 = route.params.partido.equipo2.equ_iso;
    partido = route.params.partido;
    usuario = route.params.usuario;

    let hasErrors = false;

    const save=()=>{
        setErrorMarcador(null);
        validate();
        if(!hasErrors){
            insertPronosticos({partido:partido, usuario:usuario, pro_marcador1:pro_marcador1, pro_marcador2:pro_marcador2}, ()=>{Alert.alert("CONFIRMACION","Se ha ingresado el pronostico");});
            navigation.goBack();
            route.params.fnRefresh();
        } 
    }

    const validate=()=>{
        if(pro_marcador1 == null || pro_marcador1=="" || pro_marcador2 == null || pro_marcador2==""){
            setErrorMarcador("Debe ingresar un marcador");
            hasErrors = true;
        }
        let marcador1Int = parseInt(pro_marcador1);
        let marcador2Int = parseInt(pro_marcador2);
        
        if(marcador1Int == null || isNaN(marcador1Int) || marcador1Int < 0){
            setErrorMarcador("Debe ingresar marcador entre 0 o mas");
            hasErrors = true;
        }
        if(marcador2Int == null || isNaN(marcador2Int) || marcador2Int < 0){
            setErrorMarcador("Debe ingresar marcador entre 0 o mas");
            hasErrors = true;
        }
    }

    return <View style={styles.container}>
        <View style={styles.containerMarcador}>
            <Input style={styles.input}
                value={pro_marcador1}
                onChangeText={setPro_marcador1}
                placeholder={'Marcador 1'}
                label={nombre_equipo1+" ("+iso_equipo1+")"}
                errorMessage={errorMarcador}
            />
            <Input 
                value={pro_marcador2}
                onChangeText={setPro_marcador2}
                placeholder='Marcador 2'
                label={nombre_equipo2+" ("+iso_equipo2+")"}
                errorMessage={errorMarcador}
            />
        </View>
       
        <Button
            title='Guardar'
            icon={{
                name: 'save',
                type: 'antdesign',
                color: 'white',
            }}
            buttonStyle={styles.saveButton}
            onPress={save}
        />
    </View>
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#fff',
        alignItems: 'center',
        justifyContent: 'center',
    },
    containerMarcador:{
        flexDirection:"row",
        justifyContent: 'center',
        width:150
    },
    saveButton:{
        backgroundColor: '#5dc038',
        borderRadius: 10,
    }
});