using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Alura.Loja.Testes.ConsoleApp
{
    internal class ProgramOld
    {
        public void main() 
        {
            //GravarUsandoAdoNet();
            //Objeto Relacional (ORM)
            //GravandoUsandoEntity();
            //RemoverProdutos();
            //RecuperarProdutos();
            //AlterarProduto();
        }

        private static void AlterarProduto()
        {
            //incluir porduto
            GravandoUsandoEntity();
            RecuperarProdutos();

            // Att produto
            using (var context = new ProdutoDAOEntity())
            {
                //select top 1
                Produto produto = context.Produtos().First();
                produto.Nome = "Cassino Royale - Editado";
                context.Atualizar(produto);
            }
            RecuperarProdutos();
        }

        private static void RemoverProdutos()
        {
            using (var context = new ProdutoDAOEntity())
            {
                IList<Produto> produtos = context.Produtos();
                foreach (var produto in produtos)
                {
                    context.Remover(produto);
                }
            }
        }

        private static void RecuperarProdutos()
        {
            using (var cont = new ProdutoDAOEntity())
            {
                IList<Produto> produtos = cont.Produtos();
                Console.WriteLine("Foram encontrados {0} produto(s) ", produtos.Count);
                foreach (var produto in produtos)
                {
                    Console.WriteLine(produto.Nome);
                }
            }
        }

        private static void GravandoUsandoEntity()
        {
            Produto p = new Produto();
            p.Nome = "Harry Potter e a Ordem da Fênix";
            p.Categoria = "Livros";
            //p.Preco = 19.89;

            using (var contexto = new ProdutoDAOEntity()) // Data Acess Object
            {
                contexto.Adicionar(p);
                //contexto.Produtos.AddRange(p1, p2, p3); - para incluir objetos no contexto
            }
        }

        private static void GravarUsandoAdoNet()
        {
            Produto p = new Produto();
            p.Nome = "Harry Potter e a Ordem da Fênix";
            p.Categoria = "Livros";
            //p.Preco = 19.89;

            using (var repo = new ProdutoDAO()) // Data Acess Object
            {
                repo.Adicionar(p);
            }
        }
    }
}
