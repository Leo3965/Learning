using System.Collections.Generic;

namespace Alura.Filmes.App.Negocio
{
    public class Filme
    {
        public Filme()
        {
            this.Atores = new List<FilmeAtor>();
        }
        public int Id { get; set; }
        public string Titulo { get; set; }
        public string Descricao { get; set; }
        public short Duracao { get; set; }
        public string AnoLancamento { get; set; }
        public IList<FilmeAtor> Atores { get; internal set; }

        public Idioma IdiomaFalado { get; set; }
        public Idioma IdiomaOriginal { get; set; }

        public override string ToString()
        {
            return $"Filme ({Id}): {Titulo} = {AnoLancamento}";
        }
    }
}
