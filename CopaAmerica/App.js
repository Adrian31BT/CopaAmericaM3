import { StyleSheet, Text, View } from 'react-native';
import { NavigationContainer } from '@react-navigation/native'
import { createNativeStackNavigator } from '@react-navigation/native-stack'
import { ListaPartidos } from './app/screens/ListaPartidos'
import { Inicio } from './app/screens/Inicio'
import { FormPronostico } from './app/screens/FormPronostico'

export default function App() {
  const StackPartidos = createNativeStackNavigator(); 
  return (
    <NavigationContainer >
      <StackPartidos.Navigator initialRouteName='InicioNav'>
        <StackPartidos.Screen name="InicioNav"  component={Inicio} options={{ title: 'BET', headerTitleAlign: 'center'}}/>
        <StackPartidos.Screen name="ListaPartidosNav"  component={ListaPartidos} options={{ title: 'Partidos', headerTitleAlign: 'center'}} />
        <StackPartidos.Screen name="FormPronosticosNav"  component={FormPronostico} options={{ title: 'Pronostico', headerTitleAlign: 'center'}}/>
      </StackPartidos.Navigator>
    </NavigationContainer>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
