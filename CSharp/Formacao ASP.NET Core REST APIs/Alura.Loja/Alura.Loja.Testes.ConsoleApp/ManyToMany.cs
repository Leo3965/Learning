using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Logging;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Alura.Loja.Testes.ConsoleApp
{
    internal class ManyToMany
    {
        public void main()
        {
            // Migrations - Salva o estado das entidades
            // Add-Migrations {nome}
            // Update-Database - atualiza o banco de acordo com a ultima migration

            var promocaoDePascoa = new Promocao() 
            {
                Descricao = "Páscoa Feliz",
                DataInicio = DateTime.Now,
                DataTermino = DateTime.Now.AddMonths(3),        
            };

            var p1 = new Produto() { Nome = "Suco de Laranja", Categoria = "Bebidas", PrecoUnitario = 8.79, Unidade = "Litros"};
            var p2 = new Produto() { Nome = "Café", Categoria = "Bebidas", PrecoUnitario = 12.45, Unidade = "Gramas"};
            var p3 = new Produto() { Nome = "Macarrão", Categoria = "Alimentos", PrecoUnitario = 4.23, Unidade = "Gramas"};

            promocaoDePascoa.IncluiProduto(p1);
            promocaoDePascoa.IncluiProduto(p2);
            promocaoDePascoa.IncluiProduto(p3);

            //var pao = new Produto() 
            //{
            //    Nome = "Pão Francês",
            //    PrecoUnitario = 0.40,
            //    Unidade = "Unidade",
            //    Categoria = "Padaria"
            //};

            //var compra = new Compra() 
            //{
            //    Quantidade = 6,
            //    ProdutoId = pao.Id
            //};
            //compra.Preco = pao.PrecoUnitario * compra.Quantidade;

            using (var contexto = new LojaContext()) 
            {
                var serviceProvider = contexto.GetInfrastructure<IServiceProvider>();
                var loggerFactory = serviceProvider.GetService<ILoggerFactory>();
                loggerFactory.AddProvider(SqlLoggerProvider.Create());

                //contexto.Compras.Add(compra);
                contexto.Promocoes.Add(promocaoDePascoa);
                new ChangeTracker().ExibeEntries((contexto.ChangeTracker.Entries()));
                contexto.SaveChanges();
            }
        }
    }
}
