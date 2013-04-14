package com.yueyun.dao;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbArtistlist entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.yueyun.dao.TbArtistlist
 * @author MyEclipse Persistence Tools
 */

public class TbArtistlistDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(TbArtistlistDAO.class);
	// property constants
	public static final String TRACK_ID = "trackId";
	public static final String ARTIST_ID = "artistId";

	protected void initDao() {
		// do nothing
	}

	public void save(TbArtistlist transientInstance) {
		log.debug("saving TbArtistlist instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbArtistlist persistentInstance) {
		log.debug("deleting TbArtistlist instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbArtistlist findById(java.lang.Integer id) {
		log.debug("getting TbArtistlist instance with id: " + id);
		try {
			TbArtistlist instance = (TbArtistlist) getHibernateTemplate().get(
					"com.yueyun.dao.TbArtistlist", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbArtistlist instance) {
		log.debug("finding TbArtistlist instance by example");
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
		log.debug("finding TbArtistlist instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TbArtistlist as model where model."
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

	public List findByArtistId(Object artistId) {
		return findByProperty(ARTIST_ID, artistId);
	}

	public List findAll() {
		log.debug("finding all TbArtistlist instances");
		try {
			String queryString = "from TbArtistlist";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TbArtistlist merge(TbArtistlist detachedInstance) {
		log.debug("merging TbArtistlist instance");
		try {
			TbArtistlist result = (TbArtistlist) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbArtistlist instance) {
		log.debug("attaching dirty TbArtistlist instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbArtistlist instance) {
		log.debug("attaching clean TbArtistlist instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbArtistlistDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TbArtistlistDAO) ctx.getBean("TbArtistlistDAO");
	}
}