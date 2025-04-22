package com.lesofn.unittest.sample.spock

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Subject

/**
 * Demonstrating Spock's stubbing capabilities with dependency injection
 * @author sofn
 * @since 2024-04-22 22:52
 */
class Test12_Stubbing extends Specification {

    // A service that depends on a repository
    static class UserService {
        private UserRepository repository
        
        UserService(UserRepository repository) {
            this.repository = repository
        }
        
        String getUsernameById(int id) {
            def user = repository.findById(id)
            return user ? user.username : null
        }
        
        boolean isAdmin(int id) {
            def user = repository.findById(id)
            return user ? user.admin : false
        }
    }
    
    // Repository interface
    static interface UserRepository {
        User findById(int id)
    }
    
    // User model
    static class User {
        int id
        String username
        boolean admin
    }
    
    // Using @Subject to highlight the class under test
    @Subject
    UserService userService
    
    // Using @Shared for fields that should be shared between test methods
    @Shared
    def adminUser = new User(id: 1, username: "admin", admin: true)
    
    @Shared
    def regularUser = new User(id: 2, username: "user", admin: false)
    
    def "setup"() {
        // Create a stub for the repository
        def repository = Stub(UserRepository) {
            findById(1) >> adminUser
            findById(2) >> regularUser
            findById(_) >> null
        }
        
        // Inject the stub into the service
        userService = new UserService(repository)
    }
    
    def "should return username for valid user ID"() {
        expect:
        userService.getUsernameById(userId) == expectedUsername
        
        where:
        userId | expectedUsername
        1      | "admin"
        2      | "user"
        3      | null
    }
    
    def "should check admin status correctly"() {
        expect:
        userService.isAdmin(userId) == expectedStatus
        
        where:
        userId | expectedStatus
        1      | true
        2      | false
        3      | false
    }
}
