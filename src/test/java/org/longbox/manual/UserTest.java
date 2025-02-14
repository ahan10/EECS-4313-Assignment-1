package org.longbox.manual;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.longbox.domainobjects.entity.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    private User user1;
    private User user2;
    private User user3;
    private User user4;

    @BeforeEach
    void setUp() {
        user1 = new User();
        user1.setId(1L); // diff objects
        user1.setUserName("john_doe");
        user1.setFirstName("John");
        user1.setLastName("Doe");
        user1.setEmail("john.doe@example.com");
        user1.setPassword("securePass123");
        user1.setCountry("USA");
        user1.setDob(new Date());

        user2 = new User();
        user2.setId(2L);
        user2.setUserName("john_doe");
        user2.setFirstName("John");
        user2.setLastName("Doe");
        user2.setEmail("john.doe@example.com");
        user2.setPassword("securePass123");
        user2.setCountry("USA");
        user2.setDob(new Date());

        user3 = new User();
        user3.setId(4L); // diff objects
        user3.setUserName("john_doe");
        user3.setFirstName("John");
        user3.setLastName("Doe");
        user3.setEmail("john.doe@example.com");
        user3.setPassword("securePass123");
        user3.setCountry("USA");
        user3.setDob(new Date());

        user4 = new User();
        user4.setId(4L);
        user4.setUserName("john_doe");
        user4.setFirstName("John");
        user4.setLastName("Dane");
        user4.setEmail("john.doe@example.com");
        user4.setPassword("securePass123");
        user4.setCountry("USA");
        user4.setDob(new Date());
    }

    @Test
    public void testDifferentId(){
        assertNotEquals(user1, user2);
        assertNotEquals(user1.hashCode(), user2.hashCode());

        user1.setUserName("john_doe");
        user2.setId(1L);
        user2.setUserName("jane_doe");

        assertNotEquals(user1, user2);
        assertNotEquals(user1.hashCode(), user2.hashCode());

    }

    @Test
    public void testDifferentSameIDDifferentUserName_ShouldReturnFalse() {
        user1.setUserName("john_doe");
        user2.setId(1L);
        user2.setUserName("jane_doe");

        assertNotEquals(user1, user2);
        assertNotEquals(user1.hashCode(), user2.hashCode());

    }

    @Test
    public void testDifferentLastName(){
        assertNotEquals(user3, user4);
        assertNotEquals(user3.hashCode(), user4.hashCode());
    }

    @Test
    public void testDifferentFirstName(){
        user4.setFirstName("Jae");
        user4.setLastName("Doe");
        assertNotEquals(user3, user4);
        assertNotEquals(user3.hashCode(), user4.hashCode());
    }

}