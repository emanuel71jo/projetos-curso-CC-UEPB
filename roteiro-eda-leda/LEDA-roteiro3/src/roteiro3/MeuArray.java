package roteiro3;

public class MeuArray<T extends Comparable> implements Ordenador<T>{

    private T[] array;
    private int posLivre = 0;

    public MeuArray() {
        this.array = (T[]) new Comparable[30];
    }

    public int getTamanho() {
        return this.posLivre;
    }
    
    /**
     * Inserindo um elemento na proxima posição livre.
     *
     * @param element objeto a ser adicionado
     */
    @Override
    public void inserir(T element) {
        this.array[posLivre++] = element;
        aumentarArray();

    }

    /**
     * Verificando se é necessario o aumento do array Se o array tiver mais de
     * 80% preenchido é necessario o aumento de 10% dele.
     */
    private void aumentarArray() {
        if (!arrayDisponivel()) {
            T aux[] = (T[]) new Comparable[(int) ((this.array.length * 0.1) + this.array.length)];
            for (int i = 0; i < posLivre; i++) {
                aux[i] = this.array[i];
            }
            this.array = aux;
        }
    }

    /**
     *
     * @return se é necessario o aumento do array
     */
    private boolean arrayDisponivel() {
        return posLivre < (this.array.length * 0.8);
    }

    /**
     * Localizando o objeto a partir de seu codigo. (Pesquisa Linear).
     *
     * @param cod codigo do objeto
     * @return o objeto
     */
    @Override
    public T localizar(String cod) {   
        for (int i = 0; i < posLivre; i++) {
            if (this.array[i].equals(cod)){
                return this.array[i];
            }
        }
        return null;
    }

    /**
     * Metodo de ordenação insertionSort().
     *
     * @return array ordenado.
     */
    @Override
    public T[] insertionSort() {
        for (int i = 1; i < posLivre; i++) {
            T aux = this.array[i];
            int j = i - 1;
            while (j >= 0 && 1 > this.array[i].compareTo(aux)) {
                this.array[j + 1] = this.array[j];
                this.array[j--] = aux;
            }
            this.array[j + 1] = aux;
        }
        this.array = (T[]) this.array;
        return (T[]) this.array;
    }

    /**
     * Metodo de ordenação bubbleSort()
     *
     * @return this.array ordenado
     */
    @Override
    public T[] bubbleSort() {
        boolean houveTroca;
        do {
            houveTroca = false;
            for (int i = 0; i < posLivre - 2; i++) {
                if (-1 < this.array[i].compareTo(this.array[i + 1])) {
                    T aux = this.array[i];
                    this.array[i] = this.array[i + 1];
                    this.array[i + 1] = aux;
                    houveTroca = true;
                }
            }
        } while (houveTroca);
        return (T[]) this.array;
    }

    /**
     * Metodo de ordenação bubbleSortDinamico() realiza duas trocas
     * simultaneamente se necessario
     *
     * @return array ordenado
     */
    @Override
    public T[] bubbleSortDinamico() {
        boolean houveTroca;
        do {
            houveTroca = false;
            for (int i = 0; i < posLivre - 2; i++) {
                if (-1 < this.array[i].compareTo(this.array[i + 1])) {
                    T aux = this.array[i];
                    this.array[i] = this.array[i + 1];
                    this.array[i + 1] = aux;
                    houveTroca = true;
                }
                if (-1 < this.array[i - 1].compareTo(this.array[i - 2])) {
                    T aux = this.array[i - 1];
                    this.array[i - 1] = this.array[i - 2];
                    this.array[i - 2] = aux;
                    houveTroca = true;
                }
            }
        } while (houveTroca);
        return (T[]) this.array;
    }

    /**
     * Metodo de ordenação selectionSort()
     *
     * @return array ordenado
     */
    @Override
    public T[] selectionSort() {
        int min;
        for (int i = 0; i < posLivre; i++) {
            min = i;
            for (int j = i + 1; j < posLivre; j++) {
                if (-1 < this.array[min].compareTo(this.array[j])) {
                    min = j;
                }
            }
            if (0 != this.array[i].compareTo(this.array[min])) {
                T aux = this.array[i];
                this.array[i] = this.array[min];
                this.array[min] = aux;
            }
        }
        return (T[]) this.array;
    }

    /**
     * Metodo que fara uma busca binaria do array
     *
     * @param cod Obj a ser buscado
     * @return o objeto econtrado
     */
    
    public T buscaBinaria(T element) {
        if(!arrayNaoOrdenado()){
            insertionSort();
        }
        int min = 0, max = posLivre, meio = 0;
        while (min <= max) {
            meio = (min + max) / 2;
            if (this.array[meio].equals(element)) {
                return this.array[meio];
            }
            if (-1 < this.array[meio].compareTo(element)) {
                max = meio - 1;
            } else {
                min = meio + 1;
            }
        }
        return null;
    }

    /**
     * Insere de forma ordenada um elemento no array
     *
     * @param element objeto a ser inserido
     */
    @Override
    public void inserirOrdenado(T element) {
        if(!arrayNaoOrdenado()){
            insertionSort();
        }
        int pos = 0;
        for (int i = 0; i < posLivre; i++) {
            if (this.array[i].compareTo(element) > -1) {
                pos = i;
                deslocarArray(pos);
                break;
            }
        }
        this.array[pos] = element;
    }

    /**
     * desloca os elementos do array uma posição
     *
     * @param pos posição ate onde sera deslocado o array
     */
    private void deslocarArray(int pos) {
        for (int i = posLivre++; i > pos; i--) {
            this.array[i] = this.array[i - 1];
        }
        aumentarArray();
    }

    /**
     * Remove de forma ordenada um objeto do array
     *
     * @param element objeto a ser removido
     */
    @Override
    public void removeOrdenado(T element) {
        if(!arrayNaoOrdenado()){
            insertionSort();
        }
        for (int i = 0; i < posLivre; i++) {
            if (this.array[i].equals(element)) {
                this.array[i] = null;
                reordenarArray(i);
                break;
            }
        }
    }

    /**
     * Reordenação do array após a remorção
     *
     * @param i posição que está "vazia"
     */
    private void reordenarArray(int i) {
        for (int j = i; i < posLivre--; i++) {
            this.array[j] = this.array[j + 1];
        }
    }

    /**
     * Serve para verificar se o array esta ordenado
     * @return se está ordenado
     */
    private boolean arrayNaoOrdenado() {
        for(int i = 0; i < posLivre - 1; i++){
            if(1 == this.array[i].compareTo(this.array[i + 1])){
                return false;
            }
        }
        return true;
    }

}
