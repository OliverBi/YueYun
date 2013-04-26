package com.yueyun.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbTrackrank entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.yueyun.dao.TbTrackrank
 * @author MyEclipse Persistence Tools
 */

public class TbTrackrankDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TbTrackrankDAO.class);
	// property constants
	public static final String TRACK_ID = "trackId";
	public static final String TRACK_RANK = "trackRank";

	protected void initDao() {
		// do nothing
	}

	public void save(TbTrackrank transientInstance) {
		log.debug("saving TbTrackrank instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbTrackrank persistentInstance) {
		log.debug("deleting TbTrackrank instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbTrackrank findById(java.lang.Integer id) {
		log.debug("getting TbTrackrank instance with id: " + id);
		try {
			TbTrackrank instance = (TbTrackrank) getHibernateTemplate().get(
					"com.yueyun.dao.TbTrackrank", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbTrackrank instance) {
		log.debug("finding TbTrackrank instance by example");
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
		log.debug("finding TbTrackrank instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbTrackrank as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTrackId(Object trackId) {
		return findByProperty(TRACK_ID, trackId);
	}

	public List findByTrackRank(Object trackRank) {
		return findByProperty(TRACK_RANK, trackRank);
	}

	public List findAll() {
		log.debug("finding all TbTrackrank instances");
		try {
			String queryString = "from TbTrackrank";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbTrackrank merge(TbTrackrank detachedInstance) {
		log.debug("merging TbTrackrank instance");
		try {
			TbTrackrank result = (TbTrackrank) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbTrackrank instance) {
		log.debug("attaching dirty TbTrackrank instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbTrackrank instance) {
		log.debug("attaching clean TbTrackrank instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbTrackrankDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TbTrackrankDAO) ctx.getBean("TbTrackrankDAO");
	}
}