package com.yueyun.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbAlbumNopreference entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.yueyun.dao.TbAlbumNopreference
 * @author MyEclipse Persistence Tools
 */

public class TbAlbumNopreferenceDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TbAlbumNopreferenceDAO.class);
	// property constants
	public static final String NOPREFERENCE = "nopreference";

	protected void initDao() {
		// do nothing
	}

	public void save(TbAlbumNopreference transientInstance) {
		log.debug("saving TbAlbumNopreference instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbAlbumNopreference persistentInstance) {
		log.debug("deleting TbAlbumNopreference instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbAlbumNopreference findById(com.yueyun.dao.TbAlbumNopreferenceId id) {
		log.debug("getting TbAlbumNopreference instance with id: " + id);
		try {
			TbAlbumNopreference instance = (TbAlbumNopreference) getHibernateTemplate()
					.get("com.yueyun.dao.TbAlbumNopreference", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbAlbumNopreference instance) {
		log.debug("finding TbAlbumNopreference instance by example");
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
		log.debug("finding TbAlbumNopreference instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbAlbumNopreference as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNopreference(Object nopreference) {
		return findByProperty(NOPREFERENCE, nopreference);
	}

	public List findAll() {
		log.debug("finding all TbAlbumNopreference instances");
		try {
			String queryString = "from TbAlbumNopreference";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbAlbumNopreference merge(TbAlbumNopreference detachedInstance) {
		log.debug("merging TbAlbumNopreference instance");
		try {
			TbAlbumNopreference result = (TbAlbumNopreference) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbAlbumNopreference instance) {
		log.debug("attaching dirty TbAlbumNopreference instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbAlbumNopreference instance) {
		log.debug("attaching clean TbAlbumNopreference instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbAlbumNopreferenceDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TbAlbumNopreferenceDAO) ctx.getBean("TbAlbumNopreferenceDAO");
	}
}