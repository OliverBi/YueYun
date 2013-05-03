package com.yueyun.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbTrackplaylist entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.yueyun.dao.TbTrackplaylist
 * @author MyEclipse Persistence Tools
 */

public class TbTrackplaylistDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TbTrackplaylistDAO.class);
	// property constants
	public static final String TRACK_ID = "trackId";
	public static final String USER_PLAY_LIST_ID = "userPlayListId";

	protected void initDao() {
		// do nothing
	}

	public void save(TbTrackplaylist transientInstance) {
		log.debug("saving TbTrackplaylist instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbTrackplaylist persistentInstance) {
		log.debug("deleting TbTrackplaylist instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbTrackplaylist findById(java.lang.Integer id) {
		log.debug("getting TbTrackplaylist instance with id: " + id);
		try {
			TbTrackplaylist instance = (TbTrackplaylist) getHibernateTemplate()
					.get("com.yueyun.dao.TbTrackplaylist", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbTrackplaylist instance) {
		log.debug("finding TbTrackplaylist instance by example");
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
		log.debug("finding TbTrackplaylist instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbTrackplaylist as model where model."
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

	public List findByUserPlayListId(Object userPlayListId) {
		return findByProperty(USER_PLAY_LIST_ID, userPlayListId);
	}

	public List findAll() {
		log.debug("finding all TbTrackplaylist instances");
		try {
			String queryString = "from TbTrackplaylist";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbTrackplaylist merge(TbTrackplaylist detachedInstance) {
		log.debug("merging TbTrackplaylist instance");
		try {
			TbTrackplaylist result = (TbTrackplaylist) getHibernateTemplate()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbTrackplaylist instance) {
		log.debug("attaching dirty TbTrackplaylist instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbTrackplaylist instance) {
		log.debug("attaching clean TbTrackplaylist instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbTrackplaylistDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TbTrackplaylistDAO) ctx.getBean("TbTrackplaylistDAO");
	}
}