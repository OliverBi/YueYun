package com.yueyun.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbUser entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.yueyun.dao.TbUser
 * @author MyEclipse Persistence Tools
 */

public class TbUserDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(TbUserDAO.class);
	// property constants
	public static final String USER_NAME = "userName";
	public static final String USER_PASSWORD = "userPassword";
	public static final String USER_EMAIL = "userEmail";
	public static final String USER_GENDER = "userGender";
	public static final String USER_DESCRIPTION = "userDescription";
	public static final String USER_AVATAR_URL = "userAvatarUrl";

	protected void initDao() {
		// do nothing
	}

	public void save(TbUser transientInstance) {
		log.debug("saving TbUser instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbUser persistentInstance) {
		log.debug("deleting TbUser instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbUser findById(java.lang.Integer id) {
		log.debug("getting TbUser instance with id: " + id);
		try {
			TbUser instance = (TbUser) getHibernateTemplate().get(
					"com.yueyun.dao.TbUser", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbUser instance) {
		log.debug("finding TbUser instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbUser instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbUser as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List findByUserPassword(Object userPassword) {
		return findByProperty(USER_PASSWORD, userPassword);
	}

	public List findByUserEmail(Object userEmail) {
		return findByProperty(USER_EMAIL, userEmail);
	}

	public List findByUserGender(Object userGender) {
		return findByProperty(USER_GENDER, userGender);
	}

	public List findByUserDescription(Object userDescription) {
		return findByProperty(USER_DESCRIPTION, userDescription);
	}

	public List findByUserAvatarUrl(Object userAvatarUrl) {
		return findByProperty(USER_AVATAR_URL, userAvatarUrl);
	}

	public List findAll() {
		log.debug("finding all TbUser instances");
		try {
			String queryString = "from TbUser";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public TbUser merge(TbUser detachedInstance) {
		log.debug("merging TbUser instance");
		try {
			TbUser result = (TbUser) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbUser instance) {
		log.debug("attaching dirty TbUser instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbUser instance) {
		log.debug("attaching clean TbUser instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbUserDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TbUserDAO) ctx.getBean("TbUserDAO");
	}
}