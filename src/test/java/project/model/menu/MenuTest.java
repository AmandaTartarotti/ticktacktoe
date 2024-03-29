package project.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import project.model.Menu.Menu;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MenuTest {
//In certain cases, using the 'menu' variable would generate issues with the errorprone program
    private Menu menu;
    @BeforeEach
    void set_up()
    {
        this.menu = new Menu();
    }

    @Test
    void menuLoopsUpwards() {
        Menu menu2 = new Menu();
        menu2.previousEntry();
        Assertions.assertTrue(menu2.isSelected(2));
        Assertions.assertFalse(menu2.isSelected(0));
        Assertions.assertFalse(menu2.isSelected(1));

        menu2.previousEntry();
        Assertions.assertTrue(menu2.isSelected(1));
        Assertions.assertFalse(menu2.isSelected(0));
        Assertions.assertFalse(menu2.isSelected(2));

        menu2.previousEntry();
        Assertions.assertTrue(menu2.isSelected(0));
        Assertions.assertFalse(menu2.isSelected(1));
        Assertions.assertFalse(menu2.isSelected(2));
    }

    @Test
    void menuLoopsDownwards () {
        Menu menu2 = new Menu();

        menu2.nextEntry();
        Assertions.assertTrue(menu2.isSelected(1));

        menu2.nextEntry();
        Assertions.assertTrue(menu2.isSelected(2));

        menu2.nextEntry();
        Assertions.assertTrue(menu2.isSelected(0));
    }

    @Test
    void getEntryTest() {
        Menu menu2 = new Menu();
        Assertions.assertEquals("Start",menu2.getEntry(0));
        Assertions.assertEquals("Rules",menu2.getEntry(1));
        Assertions.assertEquals("Exit",menu2.getEntry(2));
    }

    @Test
    void startSelected() {
        Menu menu2 = new Menu();

        Assertions.assertTrue(menu2.isSelectedStart());
    }

    @Test
    void exitSelected() {
        menu = Mockito.mock(Menu.class);
        when(menu.isSelected(2)).thenReturn(true);
        when(menu.isSelectedExit()).thenCallRealMethod();
        Assertions.assertTrue(menu.isSelectedExit());
    }

    @Test
    void rulesSelected() {
        menu = Mockito.mock(Menu.class);
        when(menu.isSelected(1)).thenReturn(true);
        when(menu.isSelectedRules()).thenCallRealMethod();
        Assertions.assertTrue(menu.isSelectedRules());
    }

    @Test
    void numEntriesTest(){
        Menu menu2 = new Menu();

        Assertions.assertEquals(3,menu2.getNumberEntries());
    }

    @Test
    void selectedTest() {
        Menu menu2 = Mockito.spy(new Menu());
        when(menu2.isSelected(2)).thenReturn(true);
        boolean flag = menu2.isSelectedExit();
        Assertions.assertTrue(flag);
        when(menu2.isSelected(2)).thenReturn(false);
        flag = menu2.isSelectedExit();
        Assertions.assertFalse(flag);


        when(menu2.isSelected(1)).thenReturn(true);
        flag = menu2.isSelectedRules();
        Assertions.assertTrue(flag);
        when(menu2.isSelected(1)).thenReturn(false);
        flag = menu2.isSelectedRules();
        Assertions.assertFalse(flag);


        when(menu2.isSelected(0)).thenReturn(true);
        flag = menu2.isSelectedStart();
        Assertions.assertTrue(flag);
        when(menu2.isSelected(0)).thenReturn(false);
        flag = menu2.isSelectedStart();
        Assertions.assertFalse(flag);
    }
}
