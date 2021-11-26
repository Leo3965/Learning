import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class Componentes{

  static caixaDeTexto(String rotulo, String dica,TextEditingController controlador){
    return TextFormField(
      controller: controlador,
      keyboardType: TextInputType.number,
      decoration: InputDecoration(
        labelText: rotulo,
        labelStyle: TextStyle(fontSize: 18, color: Colors.black, fontWeight: FontWeight.bold),
        hintText: dica,
        hintStyle: TextStyle(fontSize: 10, color: Colors.red)
      ),
    );

  }

  static botaoSoma(Function F) {
    return RaisedButton(
      onPressed: F,
      child: Icon(
        Icons.add,
        color: Colors.blue,
        size: 50,
      )
    );
  }

  static botaoSub(Function F){
    return RaisedButton(
        onPressed: F,
      child:  Icon(
        Icons.remove,
        color: Colors.blue,
        size: 50,
      ),
    );
  }

   static botaoMult(Function F){
    return RaisedButton(
        onPressed: F,
        child:  Icon(
          Icons.clear,
          color: Colors.blue,
          size: 50,
        ),
    );
  }

  static botaoDiv(Function F){
    return RaisedButton(
        onPressed: F,
        child:  Icon(
          Icons.blur_off,
          color: Colors.blue,
          size: 50,
        ),
    );
  }

}