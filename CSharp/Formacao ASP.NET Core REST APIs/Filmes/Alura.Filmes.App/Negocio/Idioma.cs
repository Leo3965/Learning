using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Alura.Filmes.App.Negocio
{
    public class Idioma
    {
        public Idioma()
        {
            this.FilmesFalados = new List<Filme>();
            this.FilmesOriginais = new List<Filme>();
        }

        public byte Id { get; set; }
        public string Nome { get; set; }
        public IList<Filme> FilmesFalados { get; internal set; }
        public IList<Filme> FilmesOriginais { get; internal set; }

        public override string ToString()
        {
            return $"Idioma {this.Id} : {this.Nome}";
        }
    }
}
