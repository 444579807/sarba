package org.sarba.shiro.hello;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShiroDemo {


    public static void main(String[] args) {

        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        Session session = subject.getSession();
        session.setAttribute("someKey", "aValue");
        String value = (String) session.getAttribute("someKey");
        if (value.equals("aValue")) {
            System.out.println("-->Retrieved the correct value! [" + value + "]");
        }

        // let's login the current user so we can check against roles and permissions:
        if (!subject.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
            token.setRememberMe(true);
            try {
                subject.login(token);
            } catch (UnknownAccountException uae) {
                System.out.println("-->There is no user with username of " + token.getPrincipal());
            } catch (IncorrectCredentialsException ice) {
                System.out.println("-->Password for account " + token.getPrincipal() + " was incorrect!");
            } catch (LockedAccountException lae) {
                System.out.println("The account for username " + token.getPrincipal() + " is locked.  " +
                        "Please contact your administrator to unlock it.");
            }
            // ... catch more exceptions here (maybe custom ones specific to your application?
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            }
        }

        //say who they are:
        //print their identifying principal (in this case, a username):
        System.out.println("-->User [" + subject.getPrincipal() + "] logged in successfully.");

        //test a role:
        if (subject.hasRole("schwartz")) {
            System.out.println("-->May the Schwartz be with you!");
        } else {
            System.out.println("Hello, mere mortal.");
        }

        //test a typed permission (not instance-level)
        if (subject.isPermitted("lightsaber:weild")) {
            System.out.println("-->You may use a lightsaber ring.  Use it wisely.");
        } else {
            System.out.println("Sorry, lightsaber rings are for schwartz masters only.");
        }

        //a (very powerful) Instance Level permission:
        if (subject.isPermitted("winnebago:drive:eagle5")) {
            System.out.println("-->You are permitted to 'drive' the winnebago with license plate (id) 'eagle5'.  " +
                    "Here are the keys - have fun!");
        } else {
            System.out.println("Sorry, you aren't allowed to drive the 'eagle5' winnebago!");
        }

        //all done - log out!
        subject.logout();

        System.exit(0);


    }

}
