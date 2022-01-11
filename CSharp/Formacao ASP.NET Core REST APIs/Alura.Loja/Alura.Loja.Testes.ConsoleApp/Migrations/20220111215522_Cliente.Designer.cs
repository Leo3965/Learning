﻿using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;
using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;
using Alura.Loja.Testes.ConsoleApp;

namespace Alura.Loja.Testes.ConsoleApp.Migrations
{
    [DbContext(typeof(LojaContext))]
    [Migration("20220111215522_Cliente")]
    partial class Cliente
    {
        protected override void BuildTargetModel(ModelBuilder modelBuilder)
        {
            modelBuilder
                .HasAnnotation("ProductVersion", "1.1.2")
                .HasAnnotation("SqlServer:ValueGenerationStrategy", SqlServerValueGenerationStrategy.IdentityColumn);

            modelBuilder.Entity("Alura.Loja.Testes.ConsoleApp.Cliente", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd();

                    b.HasKey("Id");

                    b.ToTable("Clientes");
                });

            modelBuilder.Entity("Alura.Loja.Testes.ConsoleApp.Compra", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd();

                    b.Property<double>("Preco");

                    b.Property<int>("ProdutoId");

                    b.Property<int>("Quantidade");

                    b.HasKey("Id");

                    b.ToTable("Compras");
                });

            modelBuilder.Entity("Alura.Loja.Testes.ConsoleApp.Endereco", b =>
                {
                    b.Property<int>("ClienteID")
                        .ValueGeneratedOnAdd();

                    b.HasKey("ClienteID");

                    b.ToTable("Enderecos");
                });

            modelBuilder.Entity("Alura.Loja.Testes.ConsoleApp.Produto", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd();

                    b.Property<string>("Categoria");

                    b.Property<string>("Nome");

                    b.Property<double>("PrecoUnitario");

                    b.Property<string>("Unidade");

                    b.HasKey("Id");

                    b.ToTable("Produtos");
                });

            modelBuilder.Entity("Alura.Loja.Testes.ConsoleApp.Promocao", b =>
                {
                    b.Property<int>("Id")
                        .ValueGeneratedOnAdd();

                    b.Property<DateTime>("DataInicio");

                    b.Property<DateTime>("DataTermino");

                    b.Property<string>("Descricao");

                    b.HasKey("Id");

                    b.ToTable("Promocoes");
                });

            modelBuilder.Entity("Alura.Loja.Testes.ConsoleApp.PromocaoProduto", b =>
                {
                    b.Property<int>("PromocaoID");

                    b.Property<int>("ProdutoID");

                    b.HasKey("PromocaoID", "ProdutoID");

                    b.HasIndex("ProdutoID");

                    b.ToTable("PromocaoProduto");
                });

            modelBuilder.Entity("Alura.Loja.Testes.ConsoleApp.PromocaoProduto", b =>
                {
                    b.HasOne("Alura.Loja.Testes.ConsoleApp.Produto", "Produto")
                        .WithMany("Promocoes")
                        .HasForeignKey("ProdutoID")
                        .OnDelete(DeleteBehavior.Cascade);

                    b.HasOne("Alura.Loja.Testes.ConsoleApp.Promocao", "Promocao")
                        .WithMany("Produtos")
                        .HasForeignKey("PromocaoID")
                        .OnDelete(DeleteBehavior.Cascade);
                });
        }
    }
}
