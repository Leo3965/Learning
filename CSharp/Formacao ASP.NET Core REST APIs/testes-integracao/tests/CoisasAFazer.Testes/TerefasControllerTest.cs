using Xunit;
using Moq;
using Alura.CoisasAFazer.WebApp.Controllers;
using Alura.CoisasAFazer.WebApp.Models;
using System;
using Microsoft.AspNetCore.Mvc;
using Alura.CoisasAFazer.Services.Handlers;
using Microsoft.Extensions.Logging;
using Alura.CoisasAFazer.Infrastructure;
using Microsoft.EntityFrameworkCore;
using Alura.CoisasAFazer.Core.Models;

namespace CoisasAFazer.Testes
{
    public class TerefasControllerTest
    {
        [Fact]
        public void DadaTarefaComInformacoesValidasDeveRetornar200()
        {
            //arrange
            var mockLogger = new Mock<ILogger<CadastraTarefaHandler>>();
            var option = new DbContextOptionsBuilder<DbTarefasContext>()
                .UseInMemoryDatabase("DbTarefas")
                .Options;
            var contexto = new DbTarefasContext(option);

            contexto.Categorias.Add(new Categoria(1, "Estudo"));
            contexto.SaveChanges();


            var repo = new RepositorioTarefa(contexto);
            var controlador = new TarefasController(repo, mockLogger.Object);
            var model = new CadastraTarefaVM()
            {
                IdCategoria = 1,
                Titulo = "EstudandoXunit",
                Prazo = new DateTime(2022, 01, 13)
            };

            //act
            var retorno = controlador.EndpointCadastraTarefa(model);

            //assert
            Assert.IsType<OkResult>(retorno);
        }

        [Fact]
        public void QuandoExcecaoForLancadaDeveRetornar500()
        {
            //arrange
            var mockLogger = new Mock<ILogger<CadastraTarefaHandler>>();
            
            var mockRepo = new Mock<IRepositorioTarefas>();

            mockRepo.Setup(r => r.ObtemCategoriaPorId(1))
            .Returns(new Categoria(1, "Estudo"));

            mockRepo.Setup(r => r.IncluirTarefas(It.IsAny<Tarefa[]>()))
                .Throws(new Exception("Houve um erro"));


            var controlador = new TarefasController(mockRepo.Object, mockLogger.Object);
            var model = new CadastraTarefaVM()
            {
                IdCategoria = 1,
                Titulo = "EstudandoXunit",
                Prazo = new DateTime(2022, 01, 13)
            };

            //act
            var retorno = controlador.EndpointCadastraTarefa(model);

            //assert
            Assert.IsType<StatusCodeResult>(retorno); //500
            var statusCode = (retorno as StatusCodeResult).StatusCode;
            Assert.Equal(500, statusCode);
        }
    }
}
