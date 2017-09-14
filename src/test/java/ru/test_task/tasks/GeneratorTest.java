package ru.test_task.tasks;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;
import static ru.test_task.tasks.Generator.*;

public class GeneratorTest {
    @Test
    public void testAnimal() throws Exception {
        Animal animal_d = createAnimal("max", "Dog", 1);
        Animal animal_c = createAnimal("mary", "Cat", 2);
        Animal animal_cd = createAnimal("moe", "CatDog", 3);

        assertEquals("max", animal_d.getName());
        assertEquals("mary", animal_c.getName());
        assertEquals("moe", animal_cd.getName());
    }

    @Test
    public void testEmptyAnimal() throws Exception {
        Animal animal_empty = createEmptyAnimal(4);
        assertEquals("There's no animal", animal_empty.getName());
    }

}