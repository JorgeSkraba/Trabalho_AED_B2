public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria(int conteudo) {
        raiz = new No(conteudo);
    }

    public boolean estaVazia() {
        if(raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public void inserirRecursivoRedirecionamentoOtimizado(int conteudo) {
        No novoNo = new No(conteudo);
        this.raiz = inserirRecursivoOtimizado(this.raiz, novoNo);
    }

    private No inserirRecursivoOtimizado(No aux, No novoNo) {

        if(aux == null) {
            return novoNo;
        } else if (novoNo.getConteudo() > aux.getConteudo()) {
            novoNo.setAnterior(aux);
            aux.setDireita(inserirRecursivoOtimizado(aux.getDireita(), novoNo));
        } else {
            novoNo.setAnterior(aux);
            aux.setEsquerda(inserirRecursivoOtimizado(aux.getEsquerda(), novoNo));
        }
        return aux;
    }

    public void remover(int conteudo) {
        raiz = removerRecursivo(raiz, conteudo);
    }

    private No removerRecursivo(No atual, int conteudo) {
        if (atual == null) {
            return null;
        }

        //caso o conteudo atual seja maior ou menor que o conteudo buscado, a busca continua sendo pela direita ou esquerda respectivamente
        if (conteudo < atual.getConteudo()) {
            //a esquerda do no atual vai mudar caso ela seja o conteudo buscado, se não retornará o mesmo valor
            atual.setEsquerda(removerRecursivo(atual.getEsquerda(), conteudo));
        } else if (conteudo > atual.getConteudo()) {
            //a direita do no atual vai mudar caso ela seja o conteudo buscado, se não retornará o mesmo valor
            atual.setDireita(removerRecursivo(atual.getDireita(), conteudo));
            // caso o conteudo atual não seja maior nem menor que o buscado, então ele é o buscado
        } else {

            //caso o nó ser um nó sem filhos, então o apontamento do seu antecessor vira nulo
            if (atual.getEsquerda() == null && atual.getDireita() == null) {
                return null;
            }

            //caso o nó tenha um filho apenas, seu antecessor apontará para o seu filho, excluindoo nó da árvore
            if (atual.getEsquerda() == null) {
                return atual.getDireita();
            } else if (atual.getDireita() == null) {
                return atual.getEsquerda();
            }

            //caso o nó tenha dois filhos, é buscado o nó sucessor (menor da direita)
            No sucessor = encontrarMenor(atual.getDireita());
            //O conteudo do atual vira o conteudo do sucessor
            atual.setConteudo(sucessor.getConteudo());
            //o menor da direita é removido utilizando a recursão novamente
            atual.setDireita(removerRecursivo(atual.getDireita(), sucessor.getConteudo()));
        }
        return atual;
    }

    private No encontrarMenor(No no) {
        while (no.getEsquerda() != null) {
            no = no.getEsquerda();
        }
        return no;
    }

    public void visualizarPreOrdem() {
        preOrdem(this.raiz);
    }
    public void preOrdem(No no) {
        if(no == null) {
            return;
        }
        System.out.println(no.getConteudo());
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }

    public void visualizarEmOrdem() {
        emOrdem(this.raiz);
    }
    public void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getEsquerda());
        System.out.println(no.getConteudo());
        emOrdem(no.getDireita());
    }

    public void visualizarPosOrdem() {
        posOrdem(this.raiz);
    }
    public void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.println(no.getConteudo());
    }
}
