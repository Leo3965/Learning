import React, {Component} from "react";
import "./estilo.css";
import CardNota from "../cardNota";

class ListaDeNotas extends Component {

    constructor() {
        super();
        this.state = {notas: []}
        this._novasNotas = this._novasNotas.bind(this)
    }

    componentDidMount() {
        this.props.notas.inscrever( this._novasNotas)
    }

    componentWillUnmount() {
        this.props.notas.desinscrever( this._novasNotas)
    }

    _novasNotas(notas){
        this.setState({...this.state,notas})
    }

    render() {
        return (
            <ul className="lista-notas">
                {this.state.notas.map((nota, index) => {
                    return (
                        <li className="lista-notas_item" key={index}>
                            <CardNota
                                categoria={nota.categoria}
                                index={index}
                                titulo={nota.titulo}
                                texto={nota.texto}
                                deletarNota={this.props.deletarNota}
                            />
                        </li>
                    );
                })}
            </ul>
        );
    }
}

export default ListaDeNotas;
