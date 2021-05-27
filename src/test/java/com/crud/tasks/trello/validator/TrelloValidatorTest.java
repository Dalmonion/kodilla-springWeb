package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrelloValidatorTest {

    @Test
    void validateBoardsTest() {
        //Given
        TrelloValidator validator = new TrelloValidator();
        TrelloList trelloList1 = new TrelloList("1", "testname", true);
        TrelloList trelloList2 = new TrelloList("2", "testname", false);
        List<TrelloList> trelloLists = Arrays.asList(trelloList1, trelloList2);

        TrelloBoard trelloBoard1 = new TrelloBoard("1", "test", trelloLists);
        TrelloBoard trelloBoard2 = new TrelloBoard("2", "other name", trelloLists);
        List<TrelloBoard> trelloBoards = Arrays.asList(trelloBoard1, trelloBoard2);

        //When
        List<TrelloBoard> filteredBoards = validator.validateTrelloBoards(trelloBoards);

        //Then
        assertEquals(1, filteredBoards.size());
    }

}