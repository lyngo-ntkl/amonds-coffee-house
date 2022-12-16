package com.lyngo.amondscoffeehouse.dao;

import com.lyngo.amondscoffeehouse.dto.Account;
import com.lyngo.amondscoffeehouse.utils.EncryptionUtils;
import com.lyngo.amondscoffeehouse.utils.SessionFactoryUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AccountDAO implements IAccountDAO{

    private final SessionFactory sessionFactory;
    public AccountDAO(){
        sessionFactory = SessionFactoryUtils.getSessionFactory();
    }

    @Override
    public boolean insertAccount(Account account) {
        boolean check = true;
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(account);
            transaction.commit();
        } catch (Exception e){
            e.printStackTrace();
            check = false;
            if(transaction != null){
                transaction.rollback();
            }
        }
        return check;
    }

    @Override
    public boolean updateAccount(Account account) {
        boolean check = false;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            Query<Account> query = session.createQuery("update Account set email=:email, password=:password, username=:username, phone=:phone, status=:status where accountId=:accountId", Account.class);
            query.setParameter("accountId", account.getAccountId());
            query.setParameter("email", account.getEmail());
            query.setParameter("password", account.getPassword());
            query.setParameter("username", account.getUsername());
            query.setParameter("phone", account.getPhone());
            query.setParameter("status", account.isStatus());
            check = query.executeUpdate()>0;
            if(check){
                transaction.commit();
            }
//            session.merge(account);
        } catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }
        return check;
    }

    @Override
    public boolean deleteAccount(Account account) {
        boolean check = false;
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()){
            transaction = session.beginTransaction();
            Query<Account> query = session.createQuery("delete from Account where accountId=:accountId", Account.class);
            query.setParameter("accountId", account.getAccountId());
            check = query.executeUpdate()>0;
            if(check){
                transaction.commit();
            }
//            session.remove(account);
        } catch (Exception e){
            e.printStackTrace();
            if(transaction != null){
                transaction.rollback();
            }
        }
        return check;
    }

    @Override
    public Account getAccount(String email, String password) {
        Account acc = null;
        try (Session session = sessionFactory.openSession()) {
            Query<Account> query = session.createQuery("FROM Account WHERE email=:email and password=:password and status=true",
                    Account.class);
            query.setParameter("email", email);
            password = EncryptionUtils.encrypt(password);
            query.setParameter("password", password);
            if(query.getResultList().size() == 1){
                acc = query.getResultList().get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acc;
    }

    @Override
    public List<Account> getAccounts() {
        List<Account> accounts = null;
        try (Session session = sessionFactory.openSession()) {
            Query<Account> query = session.createQuery("from Account", Account.class);
            accounts = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }
}
