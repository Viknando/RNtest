/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, {Component} from 'react';
import {
    Platform,
    StyleSheet,
    Text,
    View,
    NativeModules
} from 'react-native';

export default class pageOne extends Component<> {
    render() {
        return (
            <View style={styles.container}>
                <Text style={styles.welcome}
                      onPress={() => NativeModules.Native_Module.startActivityFromJS("com.rnjswithnative.BActivity", "this msg from RN")}>
                    Jump to NativePage!!!
                </Text>
                <Text style={styles.welcome}
                      onPress={() => NativeModules.Native_Module.sendMsgFromJSandCallBack("this msg is from rn", (msg) => {
                          alert(msg)
                      })}>
                    Sending 'this msg is from RN',native toasts and callback to RN!
                </Text>
            </View>
        );
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#F5FCFF',
    },
    welcome: {
        fontSize: 20,
        textAlign: 'center',
        margin: 10,
    },
    instructions: {
        textAlign: 'center',
        color: '#333333',
        marginBottom: 5,
    },
});