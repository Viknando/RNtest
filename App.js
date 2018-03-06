/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, {Component} from 'react';
import {
    StyleSheet,
    Text,
    View,
    Button,
    NativeModules,
    DeviceEventEmitter,
} from 'react-native';


/**
 * 获取一个联系人的信息
 */
export default class AAPP extends Component {
    state = {
        /*初始化msg*/
        msg: '暂时无信息',
    }

    /**
     * 调用Native页面选择联系人
     */
    pressSelectContract() {
        // console.log('pressSelectContract');
        // 调用Native页面
        NativeModules.ExampleMod.handleMessage("I press select button.");
    }

    handleAndroidMessage(androidMeg) {
        this.setState({msg: androidMeg});
    }

    componentWillMount() {
        DeviceEventEmitter.addListener('AndroidToRNMessage', this.handleAndroidMessage.bind(this));
    }

    componentWillUnmount() {
        DeviceEventEmitter.removeAllListeners();
    }

    render() {
        return (
            <View style={styles.container}>
              <Text style={styles.welcome}>
                这是一个常量:{NativeModules.ExampleMod.BB}
              </Text>
              <Text style={styles.welcome}>
                  {this.state.msg}
              </Text>
              <Button
                  title="点击选择联系人"
                  onPress={this.pressSelectContract}
                  accessibilityLabel='这个button的Label'
              />
            </View >
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