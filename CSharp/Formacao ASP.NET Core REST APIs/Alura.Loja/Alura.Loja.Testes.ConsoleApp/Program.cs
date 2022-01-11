using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Alura.Loja.Testes.ConsoleApp
{
    class Program
    {
        //Install-Package Microsoft.EntityFrameworkCore.SqlServer -Version 1.1
        //Install - Package Microsoft.EntityFrameworkCore.Tools - Version 1.1.1
        static void Main(string[] args)
        {
            //new ProgramOld().main();
            //new ChangeTracker().main();
            //new ManyToMany().main();
            //new OneToOne().main();
            new Join().main();
        }
    }
}
