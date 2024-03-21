// Grupo: José Miguel Prieto Páez y Daniel Rodríguez Sánchez
package org.mps.deque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
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


    }

    @Nested
    @DisplayName("When the list has one element")
    class WhenTheListHasOneElement{

        @BeforeEach
        public void InsertElementOnNewList(){
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
        public void sizeReturnsZero(){
            int longitudEsperada = 1;

            int longitudObtenida = lista.size();

            assertEquals(longitudEsperada,longitudObtenida);
        }
    }

    @Nested
    @DisplayName("When the list has multiple elements")
    class WhenTheListHasMultipleElements{

        @BeforeEach
        public void InsertMultipleElementsIntoNewList(){
            lista = new DoubleLinkedList<>();
            elementoAlPrincipio = Integer.MIN_VALUE;
            elementoAlFinal = Integer.MAX_VALUE;
            lista.append(12345);
            lista.prepend(elementoAlPrincipio);
            lista.append(elementoAlFinal);
        }

        @Test
        @DisplayName("append sets first to the element")
        public void appendSetsFirstToTheElement(){
            int elemento = 0;
            int longitudInicial = lista.size();

            lista.append(elemento);

            assertNotEquals(lista.first(), lista.last());
            assertEquals(lista.last(), elemento);
            assertEquals(longitudInicial + 1, lista.size());
        }

        @Test
        @DisplayName("prepend sets last to the element")
        public void prependSetsLastToTheElement() {
            int elemento = 0;
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

    }
}
