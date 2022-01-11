using System;

namespace Alura.Loja.Testes.ConsoleApp
{
    internal class OneToOne
    {
        internal void main()
        {
            var fulano = new Cliente() 
            {
                Nome = "Fulaninho de Tal",
                EnderecoDeEntrega = new Endereco() 
                {
                    Numero = 12,
                    Logradouro = "Rua dos inválidos",
                    Complemento = "Sobrado",
                    Bairro = "Centro",
                    Cidade = "São Paulo"
                }
            };

            using (var contexto = new LojaContext()) 
            {
            }

        }
    }
}