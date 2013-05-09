package com.yueyun.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbTrackNopreference entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.yueyun.dao.TbTrackNopreference
 * @author MyEclipse Persistence Tools
 */

public class TbTrackNopreferenceDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TbTrackNopreferenceDAO.class);
	// property constants
	public static final String NOPREFERENCE = "nopreference";

	protected void initDao() {
		// do nothing
	}

	public void save(TbTrackNopreference transientInstance) {
		log.debug("saving TbTrackNopreference instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbTrackNopreference persistentInstance) {
		log.debug("deleting TbTrackNopreference instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbTrackNopreference findById(com.yueyun.dao.TbTrackNopreferenceId id) {
		log.debug("getting TbTrackNopreference instance with id: " + id);
		try {
			TbTrackNopreference instance = (TbTrackNopreference) getHibernateTemplate()
					.get("com.yueyun.dao.TbTrackNopreference", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbTrackNopreference instance) {
		log.debug("finding TbTrackNopreference instance by example");
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
		log.debug("finding TbTrackNopreference instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbTrackNopreference as model where model."
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
		log.debug("finding all TbTrackNopreference instances");
		try {
			String queryString = "from TbTrackNopreference";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbTrackNopreference merge(TbTrackNopreference detachedInstance) {
		log.debug("merging TbTrackNopreference instance");
		try {
			TbTrackNopreference result = (TbTrackNopreference) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbTrackNopreference instance) {
		log.debug("attaching dirty TbTrackNopreference instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbTrackNopreference instance) {
		log.debug("attaching clean TbTrackNopreference instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbTrackNopreferenceDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TbTrackNopreferenceDAO) ctx.getBean("TbTrackNopreferenceDAO");
	}
}