import axios from 'axios';
import { Buffer } from 'buffer';

function getApiInstance() {
  const instance = axios.create({
    baseURL: process.env.REACT_APP_HOST,
    headers: {
      'Content-type': 'application/json',
    },
  });
  return instance;
}

function getSpotifyInstance() {
  const client_id = process.env.REACT_APP_SPOTIFY_CLIENT_ID;
  const client_secret = process.env.REACT_APP_SPOTIFY_CLIENT_SECRET;
  const auth = Buffer.from(`${client_id}:${client_secret}`).toString('base64');

  const instance = axios.create({
    headers: {
      Authorization: 'Basic ' + auth,
      'Content-Type': 'application/x-www-form-urlencoded',
    },
  });

  return instance;
}

export { getApiInstance, getSpotifyInstance };
