using Alura.Filmes.App.Dados;
using Alura.Filmes.App.Negocio;
using Microsoft.EntityFrameworkCore;
using System;
using System.Linq;

namespace Alura.Filmes.App
{
    class Program
    {
        static void Main(string[] args)
        {
            using (var contexto = new FilmesContexto())
            {
                //var filme = contexto.Filmes
                //    .Include(f => f.Atores)
                //    .ThenInclude(a => a.Ator)
                //    .FirstOrDefault();
                //Console.WriteLine(filme);
                //Console.WriteLine("Elenco ");

                var idiomas = contexto.Idiomas
                    .Include(i => i.FilmesFalados);

                foreach (var item in idiomas)
                {
                    Console.WriteLine(item);

                    foreach (var i in item.FilmesFalados)
                    {
                        Console.WriteLine(i);
                    }
                    //var entidade = contexto.Entry(item);
                    //var filmId = entidade.Property("film_id").CurrentValue;
                    //var actorId = entidade.Property("actor_id").CurrentValue;
                    //var lastUpd = entidade.Property("last_update").CurrentValue;
                    //Console.WriteLine($"Filme {filmId}, Ator {actorId}, LastUpdate: {lastUpd}");
                }

                    //var atores = contexto.Atores
                    //    .OrderByDescending(a => EF.Property<DateTime>(a, "last_update"))
                    //    .Take(10);

                    //foreach (var ator in atores)
                    //{
                    //    Console.WriteLine($"ator {ator}");
                    //}

                    //var ator = new Ator()
                    //{
                    //    PrimeiroNome = "Léo",
                    //    UltimoNome = "Freitas"
                    //};
                    //contexto.Entry(ator).Property("last_update").CurrentValue = DateTime.Now;
                    //foreach (var ator in contexto.Atores)
                    //{
                    //    System.Console.WriteLine(ator);
                    //}
            }
            
        }
    }
}