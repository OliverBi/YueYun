package com.yueyun.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbUserplaylist entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.yueyun.dao.TbUserplaylist
 * @author MyEclipse Persistence Tools
 */

public class TbUserplaylistDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TbUserplaylistDAO.class);
	// property constants
	public static final String USER_ID = "userId";
	public static final String USER_PLAY_LIST_NAME = "userPlayListName";

	protected void initDao() {
		// do nothing
	}

	public void save(TbUserplaylist transientInstance) {
		log.debug("saving TbUserplaylist instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbUserplaylist persistentInstance) {
		log.debug("deleting TbUserplaylist instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbUserplaylist findById(java.lang.Integer id) {
		log.debug("getting TbUserplaylist instance with id: " + id);
		try {
			TbUserplaylist instance = (TbUserplaylist) getHibernateTemplate()
					.get("com.yueyun.dao.TbUserplaylist", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbUserplaylist instance) {
		log.debug("finding TbUserplaylist instance by example");
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
		log.debug("finding TbUserplaylist instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbUserplaylist as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List findByUserPlayListName(Object userPlayListName) {
		return findByProperty(USER_PLAY_LIST_NAME, userPlayListName);
	}

	public List findAll() {
		log.debug("finding all TbUserplaylist instances");
		try {
			String queryString = "from TbUserplaylist";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbUserplaylist merge(TbUserplaylist detachedInstance) {
		log.debug("merging TbUserplaylist instance");
		try {
			TbUserplaylist result = (TbUserplaylist) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbUserplaylist instance) {
		log.debug("attaching dirty TbUserplaylist instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbUserplaylist instance) {
		log.debug("attaching clean TbUserplaylist instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbUserplaylistDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TbUserplaylistDAO) ctx.getBean("TbUserplaylistDAO");
	}
}