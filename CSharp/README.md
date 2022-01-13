# CSharp

## Comandos
> - dotnet new webapi 
> - code . 
> - dotnet watch run

#### Adicionando pacotes NuGet
> - Será necessário acessar o diretório de seu arquivo .csproj através do comando cd. Por exemplo, cd caminho/do/projeto/.
> - dotnet add package Microsoft.EntityFrameworkCore --version 5.0.5
> - dotnet add package Microsoft.EntityFrameworkCore.Tools --version 5.0.5
> - dotnet add package MySql.Data.EntityFrameworkCore --version 5.0.3
> -  Execute o comando para instalar o dotnet ef tools: dotnet tool install --global dotnet-ef
> - Execute o comando de criação de migration: dotnet ef migrations add FilmeMigration
> - Aplique as mudanças no banco de dados: dotnet ef database update

### Criando o DML através de código
> Add-Migration {identificador arbitrário} /
> Update-Database