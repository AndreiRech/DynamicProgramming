# ALUNO

- [Andrei Rech | 23102140](https://github.com/AndreiRech)  

# INTRODUÇÃO

Aplicação capaz de encontrar a quantidade de caminhos possíveis dado uma entrada.

Mais informações podem ser encontradas dentro de **Problema.pdf**.

# 🛠 PRÉ REQUISITOS

É necessária possuir alguma versão do [Java](https://www.java.com/pt-BR/download/) instalado em sua máquina.

# ⚙ INICIALIZAÇÃO E UTILIZAÇÃO

Para podermos utilizar o projeto, primeiro compile o programa em sua máquina.

```bash
    javac Pulos.java
```

Após isso, você pode informar os números desejados, sendo que os mesmos devem ser **obrigatóriamente**: 
- *Iniciar e terminar* com o caracter *m*
- *Binários* [01] 
    
Siga o exemplo abaixo.

```bash
    java Pulos m111111010101010010111110101011110010111110101011101011111111m 
```

O resultado esperado deve aparecer no terminal logo abaixo de seu input.

```bash
    7004000
    7004000
    7004000
```

Sendo os mesmos o resultado provenientes de:
- Método recursivo convencional
- Método recursivo utilizando vetores
- Método sem recursão

### PONTO A SER CONSIDERADO NA EXECUÇÃO

Caso utilize números muito grandes, é recomendado comentar a linha em que o método recursivo convencional é chamado, pois o mesmo é ineficiente nesses casos.
