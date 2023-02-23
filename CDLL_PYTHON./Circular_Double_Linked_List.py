from typing import TypeVar, Generic
from abc import ABC, abstractmethod

T = TypeVar('T')


class CircularDoubleLinkedList(Generic[T], ABC):

    @abstractmethod
    def isEmpty(self) -> bool:
        pass

    @abstractmethod
    def put(self, item: T) -> None:
        pass

    @abstractmethod
    def get(self) -> T:
        pass

    @abstractmethod
    def peek(self) -> T:
        pass

    @abstractmethod
    def printList(self) -> None:
        pass

    @abstractmethod
    def size(self) -> int:
        pass

    @abstractmethod
    def search(self, item: T) -> int:
        pass

    @abstractmethod
    def show_stats(self) -> None:
        pass
