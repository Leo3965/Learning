using System.Collections.Generic;

namespace Alura.Filmes.App.Negocio
{
    public class Ator
    {
        public Ator()
        {
            this.Filmografia = new List<FilmeAtor>();
        }
        public int Id { get; set; }
        public string PrimeiroNome { get; set; }
        public string UltimoNome { get; set; }
        public IList<FilmeAtor> Filmografia { get; internal set; }

        public override string ToString()
        {
            return $"Actor {this.Id}: {this.PrimeiroNome} {this.UltimoNome}";
        }
    }
}
