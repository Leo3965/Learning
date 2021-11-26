import 'dart:ui';

import 'package:flutter/material.dart';
import 'package:flutter_calculadora/Operacoes/Componentes.dart';

void main() {
  runApp(MyApp());
}
class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}


class _MyAppState extends State<MyApp> {
  // This widget is the root of your application.
  TextEditingController controllerNum1 = TextEditingController();
  TextEditingController controllerNum2 = TextEditingController();
  GlobalKey<FormState> cForm = GlobalKey<FormState>();
  String info = "";

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: telaPrincipal(),
    );
  }

  telaPrincipal() {
    return Scaffold(
      appBar: AppBar(
        title: Text(
          "Calculadora",
          style: TextStyle(
            color: Colors.black,
            fontWeight: FontWeight.bold,
            fontSize: 50,
          ),
        ),
        centerTitle: true,
        backgroundColor: Colors.white,
        actions: <Widget>[
          IconButton(icon: Icon(Icons.refresh, color: Colors.blue), onPressed: resert)
        ],
      ),
      body: barraNumeros(),
    );
  }

  barraNumeros() {
    return Form(
      key: cForm,
      child: Container(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.start,
          children: [
            Componentes.caixaDeTexto("Número 1", "Digite o primeiro número", controllerNum1),
            Componentes.caixaDeTexto("Número 2", "Digite o segundo número", controllerNum2),
            Row(
              mainAxisSize: MainAxisSize.max,
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Componentes.botaoSoma(soma),
                Componentes.botaoSub(subtracao),
                Componentes.botaoMult(multiplicacao),
                Componentes.botaoDiv(divisao),
              ],
            ),
            Text(
                "Resultado : ",
              style: TextStyle(
                color: Colors.red,
                fontWeight: FontWeight.bold,
                fontSize: 45
              ),
            ),
            Text(
                info,
              style: TextStyle(color: Colors.black, fontWeight: FontWeight.bold, fontSize: 30),
            )
          ],
        )
      ),
    );
  }

  soma(){
    setState(() {

    });
    double soma = double.parse(controllerNum1.text)+double.parse(controllerNum2.text);
    info = "O resuldado da soma é $soma";
    print(info);
  }

  subtracao(){
    setState(() {

    });
    double sub = double.parse(controllerNum1.text)-double.parse(controllerNum2.text);
    info = "O resuldado da subtração é $sub";
  }

  multiplicacao(){
    setState(() {

    });
   double mult = double.parse(controllerNum1.text)*double.parse(controllerNum2.text);
   info = "O resuldado da multiplicação é $mult";
  }

  divisao(){
    setState(() {

    });
    double div = double.parse(controllerNum1.text)/double.parse(controllerNum2.text);
    info = "O resuldado da divisão é ${div.toStringAsPrecision(2)}";
  }

  resert(){
    controllerNum1.text = "";
    controllerNum2.text = "";
    setState(() {
      info = "Digite os números";
      cForm = GlobalKey<FormState>();
    });
  }

}
