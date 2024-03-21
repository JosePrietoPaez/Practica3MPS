// Grupo: José Miguel Prieto Páez y Daniel Rodríguez Sánchez
package org.mps.deque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("A LinkedNode")
class LinkedNodeTest {

    LinkedNode<Object> node;

    @Test
    @DisplayName("Is instantiated with item, previous, and next nodes")
    void isInstantiatedWithItemPreviousNext() {
        new LinkedNode<>(new Object(), null, null);
    }

    @Nested
    @DisplayName("When previous and next are not set")
    class WhenPreviousAndNextAreNotSet {

        @BeforeEach
        void createNewNode() {
            node = new LinkedNode<>(null, null, null);
        }

        @Test
        @DisplayName("Has null item")
        void hasNullItem() {
            assertEquals(null, node.getItem());
        }

        @Test
        @DisplayName("Set item to not null")
        void setItemToNotNull(){
            node.setItem(new Object());
            assertNotNull(node.getItem());
        }

        @Test
        @DisplayName("Has null previous node")
        void hasNullPrevious() {
            assertEquals(null, node.getPrevious());
        }

        @Test
        @DisplayName("Has null next node")
        void hasNullNext() {
            assertEquals(null, node.getNext());
        }

        @Test
        @DisplayName("Is first node")
        void isFirstNode() {
            assertTrue(node.isFirstNode());
        }

        @Test
        @DisplayName("Is last node")
        void isLastNode() {
            assertTrue(node.isLastNode());
        }

        @Test
        @DisplayName("Is not a terminal node")
        void isNotATerminalNode() {
            assertFalse(node.isNotATerminalNode());
        }

        @Test
        @DisplayName("Set previous node")
        void setPreviousNode() {
            LinkedNode<Object> previousNode = new LinkedNode<>(new Object(), null, null);
            node.setPrevious(previousNode);
            assertEquals(previousNode, node.getPrevious());
        }

        @Test
        @DisplayName("Set next node")
        void setNextNode() {
            LinkedNode<Object> nextNode = new LinkedNode<>(new Object(), null, null);
            node.setNext(nextNode);
            assertEquals(nextNode, node.getNext());
        }

        @Test
        @DisplayName("Is a terminal node - is first and last")
        void isTerminalNodeFirstAndLast() {
            assertFalse(node.isNotATerminalNode());
        }

        @Test
        @DisplayName("Is a terminal node - is first and not last")
        void isTerminalNodeFirstNotLast() {
            node.setNext(new LinkedNode<>(null, null, null));
            assertFalse(node.isNotATerminalNode());
        }

        @Test
        @DisplayName("Is a terminal node - is last and not first")
        void isTerminalNodeLastNotFirst() {
            node.setPrevious(new LinkedNode<>(null, null, null));
            assertFalse(node.isNotATerminalNode());
        }

        @Nested
        @DisplayName("When previous and next are set")
        class WhenPreviousAndNextAreSet {
            @BeforeEach
            void setPreviousAndNext() {
                node.setPrevious(new LinkedNode<>(null, null, null));
                node.setNext(new LinkedNode<>(null, null, null));
            }

            @Test
            @DisplayName("Has not null previous node")
            void hasNotNullPrevious() {
                assertNotNull(node.getPrevious());
            }

            @Test
            @DisplayName("Has not null next node")
            void hasNotNullNext() {
                assertNotNull(node.getNext());
            }

            @Test
            @DisplayName("Is not first node")
            void isNotLastNode() {
                assertFalse(node.isFirstNode());
            }

            @Test
            @DisplayName("Is not last node")
            void isNotFirstNode() {
                node.setNext(new LinkedNode<>(null, null, null));
                assertFalse(node.isLastNode());
            }

            @Test
            @DisplayName("Is a terminal node - not first and not last")
            void isTerminalNodeNotFirstNotLast() {
                assertTrue(node.isNotATerminalNode());
            }
        }
    }
}
