using System;
using System.Collections.Generic;
using System.Text;

namespace Alura.CoisasAFazer.Core.Models
{
    public class CommandResult
    {
        public CommandResult(bool success)
        {
            this.IsSuccess = success;
        }
        public bool IsSuccess { get; set; }
    }
}
