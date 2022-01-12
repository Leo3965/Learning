using System.ComponentModel.DataAnnotations;

namespace FilmesApi.Models
{
    public class Filme
    {
        [Key]
        [Required]
        public int Id { get; internal set; }

        [Required(ErrorMessage = "O campo título é obrigatório")]
        public string Titulo { get; set; }

        [Required(ErrorMessage = "O campo Diretor é obrigatório")]
        public string Diretor { get; set; }

        [Required(ErrorMessage = "O campo Genero é obrigatório")]
        [StringLength(30, ErrorMessage = "O gênero não pode passar de 30 caracteres")]
        public string Genero { get; set; }

        [Required]
        [Range(1, 600, ErrorMessage = "A duração deve estar entre 1 e 600 minutos")]
        public int Duracao { get; set; }
    }
}
