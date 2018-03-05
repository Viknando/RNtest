import { AppRegistry } from 'react-native';
import App from './App';
import pageOne from './pageOne'
import BRA from './pageTwo'


//页面跳转功能实现需要 StackNavigator,如果没有react-navigation需要 yarn add react-navigation 安装react-navigation
import {
    StackNavigator,
} from 'react-navigation';
const app = StackNavigator({
    App: {screen: App},
    pageOne: {screen: pageOne},
});


AppRegistry.registerComponent('RNjsWithNative', () => app);
AppRegistry.registerComponent('BRA', () => BRA);

