package fa.training.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fa.training.dao.ProductDao;
import fa.training.entities.Product;
import fa.training.utils.HibernateUtil;

public class ProductDaoImpl implements ProductDao {

	@Override
	public boolean update(Product product) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.update(product);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean save(Product product) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(product);
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(String id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Product product = session.get(Product.class, id);
			if (product != null) {
				session.delete(product);
			}
			transaction.commit();
			return true;
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Product getById(String id) {
		Transaction transaction = null;
		Product product = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			product = session.get(Product.class, id);
			transaction.commit();
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public List<Product> getAll() {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			CriteriaBuilder builder = session.getCriteriaBuilder();

			// Create CriteriaQuery
			CriteriaQuery<Product> criteria = builder.createQuery(Product.class);

			// Set root
			Root<Product> root = criteria.from(Product.class);
			criteria.select(root);

			// Query execution
			Query<Product> query = session.createQuery(criteria);
			return query.getResultList();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> getByBrandId(int brandId) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder cb = session.getCriteriaBuilder();

			CriteriaQuery<Product> cr = cb.createQuery(Product.class);
			Root<Product> root = cr.from(Product.class);
			cr.select(root).where(cb.equal(root.get("brand"), new BrandDaoImpl().getById(brandId))); // here you pass a class field, not a table
																			// column
																			// (in this example they are called the
																			// same)
			TypedQuery<Product> query = session.createQuery(cr);
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
