namespace Alura.Loja.Testes.ConsoleApp
{
    public class Cliente
    {
        public int Id { get; set; }
        internal string Nome { get; set; }
        internal Endereco EnderecoDeEntrega { get; set; }

        public Cliente()
        {
        }
    }
}