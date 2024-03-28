// Grupo: José Miguel Prieto Páez y Daniel Rodríguez Sánchez
package org.mps.deque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("A LinkedList")
public class DoubleLinkedListTest {

    DoubleLinkedList<Integer> lista;
    int elementoAlPrincipio,elementoAlFinal;

    @Test
    @DisplayName("Is empty when instantiated")
    public void isEmptyWhenInstantiated(){
        lista = new DoubleLinkedList<>();

        assertEquals(lista.size(),0);
    }

    @Nested
    @DisplayName("When the list is empty")
    class WhenTheListIsEmpty {

        @Test
        @DisplayName("append sets first and last to the element")
        public void appendSetsFirstAndLastToTheElement(){
            lista = new DoubleLinkedList<>();
            elementoAlPrincipio = 0;

            lista.append(elementoAlPrincipio);

            assertEquals(lista.first(), lista.last());
            assertEquals(lista.last(), elementoAlPrincipio);
            assertEquals(lista.size(), 1);
        }

        @Test
        @DisplayName("prepend sets first and last to the element")
        public void prependSetsFirstAndLastToTheElement(){
            lista = new DoubleLinkedList<>();
            elementoAlPrincipio = 0;

            lista.prepend(elementoAlPrincipio);

            assertEquals(lista.first(), lista.last());
            assertEquals(lista.first(), elementoAlPrincipio);
            assertEquals(lista.size(), 1);
        }

        @Test
        @DisplayName("deleteFirst throws exception")
        public void deleteFirstThrowsException(){
            lista = new DoubleLinkedList<>();

            assertThrows(DoubleLinkedQueueException.class,
                    () -> lista.deleteFirst());
        }

        @Test
        @DisplayName("deleteLast throws exception")
        public void deleteLastThrowsException(){
            lista = new DoubleLinkedList<>();

            assertThrows(DoubleLinkedQueueException.class,
                    () -> lista.deleteLast());
        }

        @Test
        @DisplayName("first throws exception")
        public void firstThrowsException(){
            lista = new DoubleLinkedList<>();

            assertThrows(DoubleLinkedQueueException.class,
                    () -> lista.first());
        }

        @Test
        @DisplayName("last throws exception")
        public void lastThrowsException(){
            lista = new DoubleLinkedList<>();

            assertThrows(DoubleLinkedQueueException.class,
                    () -> lista.last());
        }

        @Test
        @DisplayName("size returns 0")
        public void sizeReturnsZero(){
            lista = new DoubleLinkedList<>();
            int longitudEsperada = 0;

            int longitudObtenida = lista.size();

            assertEquals(longitudEsperada,longitudObtenida);
        }

        @ParameterizedTest
        @DisplayName("get always throws exception")
        @ValueSource(ints = {-1,0,1,5})
        public void getAlwaysThrowsException(int argumento){
            lista = new DoubleLinkedList<>();

            assertThrows(IndexOutOfBoundsException.class, () -> lista.get(argumento));
        }

        @ParameterizedTest
        @DisplayName("contains always returns false") //Evidentemente, no podemos probarlo para todos los valores
        @NullSource
        @ValueSource(ints = {-1,0,5})
        public void containsAlwaysReturnsFalse(Integer argumento){
            lista = new DoubleLinkedList<>();

            boolean encontrado = lista.contains(argumento);

            assertFalse(encontrado);
        }

        @ParameterizedTest
        @DisplayName("remove has no effects")
        @NullSource
        @ValueSource(ints = {-1,0,5})
        public void removeHasNoEffects(Integer argumento){
            lista = new DoubleLinkedList<>();

            lista.remove(argumento);
            int longitudFinal = lista.size(); //Para comprobar efectos secundarios

            assertEquals(0,longitudFinal);
        }

        @Test
        @DisplayName("sort has no effects")
        public void sortHasNoEffects(){
            lista = new DoubleLinkedList<>();

            lista.sort(Integer::compareTo);
            int longitudFinal = lista.size();

            assertEquals(0,longitudFinal);
        }

    }

    @Nested
    @DisplayName("When the list has one element")
    class WhenTheListHasOneElement{

        @BeforeEach
        public void insertElementOnNewList(){
            lista = new DoubleLinkedList<>();
            elementoAlPrincipio = Integer.MAX_VALUE;
            elementoAlFinal = Integer.MAX_VALUE;
            lista.append(elementoAlPrincipio);
        }

        @Test
        @DisplayName("append sets first to the element")
        public void appendSetsFirstToTheElement(){
            int elemento = 0;

            lista.append(elemento);

            assertNotEquals(lista.first(), lista.last());
            assertEquals(lista.last(), elemento);
            assertEquals(lista.size(), 2);
        }

        @Test
        @DisplayName("prepend sets last to the element")
        public void prependSetsLastToTheElement() {
            int elemento = 0;

            lista.prepend(elemento);

            assertNotEquals(lista.first(), lista.last());
            assertEquals(lista.first(), elemento);
            assertEquals(lista.size(), 2);
        }

        @Test
        @DisplayName("deleteFirst empties the list")
        public void deleteFirstEmptiesTheList(){
            int longitudEsperada = 0;

            lista.deleteFirst();

            assertEquals(longitudEsperada, lista.size());
        }

        @Test
        @DisplayName("deleteLast empties the list")
        public void deleteLastEmptiesTheList(){
            int longitudEsperada = 0;

            lista.deleteLast();

            assertEquals(longitudEsperada, lista.size());
        }

        @Test
        @DisplayName("first returns the first element")
        public void firstReturnsTheFirstElement(){
            int elementoEsperado = elementoAlPrincipio;

            int elementoObtenido = lista.first();

            assertEquals(elementoEsperado,elementoObtenido);
        }

        @Test
        @DisplayName("last returns the last element")
        public void lastReturnsTheLastElement(){
            int elementoEsperado = elementoAlFinal;

            int elementoObtenido = lista.last();

            assertEquals(elementoEsperado,elementoObtenido);
        }

        @Test
        @DisplayName("size returns 1")
        public void sizeReturnsOne(){
            int longitudEsperada = 1;

            int longitudObtenida = lista.size();

            assertEquals(longitudEsperada,longitudObtenida);
        }

        @ParameterizedTest
        @DisplayName("get throws exception on positive or negative values")
        @ValueSource(ints = {-1,1,5})
        public void getThrowsExceptionOnPositiveAndNegativeValues(int argumento){
            assertThrows(IndexOutOfBoundsException.class, () -> lista.get(argumento));
        }

        @Test
        @DisplayName("returns the first element")
        public void getReturnsTheFirstElement(){
            int elementoEsperado = elementoAlPrincipio;

            int elementoObtenido = lista.get(0);

            assertEquals(elementoEsperado,elementoObtenido);
        }

        @Test
        @DisplayName("contains returns true if the list contains the element")
        public void containsReturnsTrueIfTheListContainsTheElement(){
            boolean encontrado = lista.contains(elementoAlPrincipio);

            assertTrue(encontrado);
        }

        @Test
        @DisplayName("contains returns false if the list does not contains the element")
        public void containsReturnsFalseIfTheListDoesNotContainsTheElement(){
            int elementoDistinto = elementoAlPrincipio - 1;

            boolean encontrado = lista.contains(elementoDistinto);

            assertFalse(encontrado);
        }

        @ParameterizedTest
        @DisplayName("remove has no effects if the element is not in the list")
        @NullSource
        @ValueSource(ints = {-1,0,5})
        public void removeHasNoEffectsIfTheElementIsNotInTheList(Integer argumento){
            int longitudInicial = lista.size();

            lista.remove(argumento);
            int longitudFinal = lista.size(); //Para comprobar efectos secundarios

            assertEquals(longitudInicial,longitudFinal);
        }

        @Test
        @DisplayName("remove has no effects if the element is not in the list")
        public void removeDeletesTheElementIfItIsInTheList(){
            int longitudInicial = lista.size();

            lista.remove(elementoAlPrincipio);
            int longitudFinal = lista.size(); //Para comprobar efectos secundarios

            assertEquals(longitudInicial-1,longitudFinal);
        }

        @Test
        @DisplayName("sort has no effects")
        public void sortHasNoEffects(){ //Como hay un elemento no puede ordenar la lista
            int longitudInicial = lista.size();

            lista.sort(Integer::compareTo);
            int longitudFinal = lista.size();

            assertEquals(longitudInicial,longitudFinal);
            assertEquals(elementoAlPrincipio,lista.get(0));
        }

    }

    @Nested
    @DisplayName("When the list has multiple elements")
    class WhenTheListHasMultipleElements{

        @BeforeEach
        public void InsertMultipleElementsIntoNewList(){
            lista = new DoubleLinkedList<>();
            elementoAlPrincipio = 0;
            elementoAlFinal = Integer.MAX_VALUE;
            lista.append(12345);
            lista.append(-12345);
            lista.prepend(elementoAlPrincipio);
            lista.append(elementoAlFinal);
        }

        @Test
        @DisplayName("append sets first to the element")
        public void appendSetsFirstToTheElement(){
            int elemento = Integer.MIN_VALUE;
            int longitudInicial = lista.size();

            lista.append(elemento);

            assertNotEquals(lista.first(), lista.last());
            assertEquals(lista.last(), elemento);
            assertEquals(longitudInicial + 1, lista.size());
        }

        @Test
        @DisplayName("prepend sets last to the element")
        public void prependSetsLastToTheElement() {
            int elemento = Integer.MIN_VALUE;
            int longitudInicial = lista.size();

            lista.prepend(elemento);

            assertNotEquals(lista.first(), lista.last());
            assertEquals(lista.first(), elemento);
            assertEquals(longitudInicial + 1, lista.size());
        }

        @Test
        @DisplayName("deleteFirst removes the first element")
        public void deleteFirstRemovesTheFirstElement(){
            int longitudEsperada = lista.size() - 1;

            lista.deleteFirst();
            int primerElemento = lista.first();

            assertEquals(longitudEsperada, lista.size());
            assertNotEquals(elementoAlPrincipio, primerElemento);
        }

        @Test
        @DisplayName("deleteLast removes the first element")
        public void deleteLastRemovesTheLastElement(){
            int longitudEsperada = lista.size() - 1;

            lista.deleteLast();
            int ultimoElemento = lista.last();

            assertEquals(longitudEsperada, lista.size());
            assertNotEquals(elementoAlFinal, ultimoElemento);
        }

        @Test
        @DisplayName("first returns the first element")
        public void firstReturnsTheFirstElement(){
            int elementoEsperado = elementoAlPrincipio;

            int elementoObtenido = lista.first();

            assertEquals(elementoEsperado,elementoObtenido);
        }

        @Test
        @DisplayName("last returns the last element")
        public void lastReturnsTheLastElement(){
            int elementoEsperado = elementoAlFinal;

            int elementoObtenido = lista.last();

            assertEquals(elementoEsperado,elementoObtenido);
        }

        @ParameterizedTest
        @DisplayName("get throws exception on values outside its range")
        @ValueSource(ints = {-1,4,5})
        public void getThrowsExceptionOnValuesOutsideItsRange(int argumento){
            assertThrows(IndexOutOfBoundsException.class, () -> lista.get(argumento));
        }

        @ParameterizedTest
        @DisplayName("returns the element at index")
        @ValueSource(ints = {0,1,2})
        public void getReturnsTheElementAtIndex(int argumento){
            int elementoObtenido = lista.get(argumento);
            //Como no podemos navegar con los nodos fuera de la lista, borramos elementos hasta encontrar el que queremos
            for (int i = 0; i < argumento; i++) {
                lista.deleteFirst();
            }

            int elementoEnPosicion = lista.first();

            assertEquals(elementoEnPosicion,elementoObtenido);
        }

        @Test
        @DisplayName("contains returns true if the list contains the element")
        public void containsReturnsTrueIfTheListContainsTheElement(){
            boolean encontrado = lista.contains(elementoAlPrincipio);

            assertTrue(encontrado);
        }

        @Test
        @DisplayName("contains returns false if the list does not contains the element")
        public void containsReturnsFalseIfTheListDoesNotContainsTheElement(){
            int elementoDistinto = elementoAlPrincipio + 3;

            boolean encontrado = lista.contains(elementoDistinto);

            assertFalse(encontrado);
        }

        @ParameterizedTest
        @DisplayName("remove has no effects if the element is not in the list")
        @NullSource
        @ValueSource(ints = {-1,1,5})
        public void removeHasNoEffectsIfTheElementIsNotInTheList(Integer argumento){
            int longitudInicial = lista.size();

            lista.remove(argumento);
            int longitudFinal = lista.size(); //Para comprobar efectos secundarios

            assertEquals(longitudInicial,longitudFinal);
        }

        @ParameterizedTest
        @DisplayName("remove has no effects if the element is not in the list")
        @ValueSource(ints = {0,1,2,3})
        public void removeDeletesTheElementIfItIsInTheList(int argumento){
            int longitudInicial = lista.size();
            int elementoAEliminar = lista.get(argumento);

            lista.remove(elementoAEliminar);
            int longitudFinal = lista.size(); //Para comprobar efectos secundarios
            boolean estaEnLista = lista.contains(elementoAEliminar); //Suponemos que el elemento solo estaba una vez

            assertEquals(longitudInicial-1,longitudFinal);
            assertFalse(estaEnLista);
        }

        @Test
        @DisplayName("sort sorts the element according to the comparer")
        public void sortSortsTheListAccordingToTheComparer(){
            int longitudInicial = lista.size();

            lista.sort(Integer::compareTo);
            int longitudFinal = lista.size();
            boolean ordenado = true;

            int i = 0;
            while (i + 1 < longitudInicial && ordenado) { //Tenemos que asegurar que está ordenada
                ordenado = lista.get(i).compareTo(lista.get(i + 1)) < 0;
                i++;
            }

            assertTrue(ordenado);
            assertEquals(longitudInicial,longitudFinal);
        }

    }
}
