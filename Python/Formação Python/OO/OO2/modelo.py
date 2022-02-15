import self as self


class Programa:
    def __init__(self, nome, ano):
        self._nome = nome.title()
        self.ano = ano
        self._likes = 0

    def dar_like(self):
        self._likes += 1

    @property
    def nome(self):
        return self._nome

    @nome.setter
    def nome(self, nome):
        self._nome = nome.title()

    @property
    def likes(self):
        return self._likes

    def __str__(self):
        return f'{self._nome} - {self.ano} - {self._likes}'


class Filme(Programa):
    def __init__(self, nome, ano, duracao):
        super().__init__(nome, ano)
        self.duracao = duracao
        self._likes = 0

    def __str__(self):
        return f'{self.nome} - {self.ano} - {self.likes} - {self.duracao}'


class Serie(Programa):
    def __init__(self, nome, ano, temporadas):
        super().__init__(nome, ano)
        self.temporadas = temporadas
        self._likes = 0

    def __str__(self):
        return f'{self.nome} - {self.ano} - {self.likes} - {self.temporadas}'


class Playlist():
    def __init__(self, nome, programas):
        self.nome = nome
        self._programas = programas

    @property
    def listagem(self):
        return self._programas

    def __len__(self):
        return len(self._programas)

    # Duck typing - se comporta como um iterável
    def __getitem__(self, item):
        return self._programas[item]

    def __str__(self):
        return f'{self.nome}: {self._programas}'


vingadores = Filme('Os Vingadores - guerra infinita', 2018, 160)
vingadores.dar_like()
serie = Serie('Never have I ever', 2021, 2)

# print(f'Nome: {vingadores.nome} - Ano: {vingadores.ano} - Temporadas: {vingadores.duracao} - Likes: {vingadores.likes}')
# print(f'Nome: {serie.nome} - Ano: {serie.ano} - Temporadas: {serie.temporadas} - Likes: {serie.likes}')
playlist = Playlist('Programas', [vingadores, serie])
for programa in playlist:
    # detalhes = programa.duracao if hasattr(programa, 'duracao') else programa.temporadas
    print(programa)

print(len(playlist))
